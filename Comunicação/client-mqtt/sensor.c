#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <mosquitto.h>
#include <unistd.h>
#include <time.h>

// Gera um valor suavemente aproximado do anterior
float next_value(float current, float min, float max) {
    float variation = ((float)rand() / RAND_MAX) * 0.5f - 0.25f; // variação entre -0.25 e +0.25
    float new_value = current + variation;

    // clamp para ficar dentro do intervalo
    if(new_value < min) new_value = min;
    if(new_value > max) new_value = max;

    return new_value;
}

int main(int argc, char *argv[]) {

    if(argc < 7) {
        printf("Uso: %s <broker> <porta> <topico> <nome_sensor> <min> <max> <intervalo_ms>\n", argv[0]);
        printf("Exemplo: %s broker.hivemq.com 1883 campus/blocoA/sala101 temp 18 35 1000\n", argv[0]);
        return 1;
    }

    const char *broker      = argv[1];
    int port                = atoi(argv[2]);
    const char *topic       = argv[3];
    const char *sensor_name = argv[4];
    float min_val           = atof(argv[5]);
    float max_val           = atof(argv[6]);
    int interval_ms         = atoi(argv[7]);

    srand(time(NULL));

    struct mosquitto *mosq;
    mosquitto_lib_init();

    mosq = mosquitto_new(sensor_name, true, NULL);
    if(!mosq) {
        printf("Erro ao criar cliente.\n");
        return 1;
    }

    if(mosquitto_connect(mosq, broker, port, 60) != MOSQ_ERR_SUCCESS) {
        printf("Falha na conexão ao broker.\n");
        return 1;
    }

    printf("[OK] Sensor '%s' iniciado no tópico '%s'.\n", sensor_name, topic);
    printf("[OK] Enviando valores entre %.2f e %.2f a cada %d ms...\n",
           min_val, max_val, interval_ms);

    float value = min_val + (float)rand() / RAND_MAX * (max_val - min_val);

    while(1) {
        value = next_value(value, min_val, max_val);

        char payload[128];
        snprintf(payload, sizeof(payload), "{\"sensor\":\"%s\", \"valor\": %.2f}",
                 sensor_name, value);

        int rc = mosquitto_publish(mosq, NULL, topic, strlen(payload),
                                   payload, 1, false);

        if(rc == MOSQ_ERR_SUCCESS) {
            printf("Enviado: %s\n", payload);
        } else {
            printf("Erro ao publicar: %s\n", mosquitto_strerror(rc));
        }

        usleep(interval_ms * 1000);
    }

    mosquitto_destroy(mosq);
    mosquitto_lib_cleanup();

    return 0;
}
