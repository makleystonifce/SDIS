# Cliente-MQTT
Este software é um simulador de sensores MQTT, desenvolvido em C, que publica valores contínuos e randômicos para um broker MQTT (como Mosquitto, HiveMQ ou EMQX).

*Ele foi criado para fins didáticos, permitindo que estudantes simulem sensores reais dentro de um ambiente de campus:*

* sensores de temperatura
* sensores de umidade
* sensores de movimento/presença
* sensores de CO₂
* ou qualquer outro sensor definido via parâmetros

Os valores variam suavemente (sem saltos bruscos) para se aproximarem de fenômenos reais.

### Funcionalidades

* Publica valores contínuos em um tópico MQTT
* Geração de dados randômicos, porém suavizados
* Todos os parâmetros definidos pela linha de comando
* Saída em formato JSON
* Loop contínuo com intervalo configurável
* Funciona com qualquer broker (Mosquitto, HiveMQ Cloud, EMQX)
* Excelente para práticas de sala de aula com MQTT

### Requisitos
```
sudo apt install libmosquitto-dev
```

### Compilação
* Compilador gcc:
```
gcc sensor_mqtt.c -o sensor_mqtt -lmosquitto
```

* Uso:
```
./sensor_mqtt <broker> <porta> <topico> <nome_sensor> <min> <max> <intervalo_ms>
```

* Exemplo de uso:
```
./sensor_mqtt broker.hivemq.com 1883 campus/blocoA/sala101 temp 18 35 1000
```