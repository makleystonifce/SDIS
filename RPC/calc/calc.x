#define PROGRAM_NUMBER 12345678
#define VERSION_NUMBER 1

/* tipo de dado que será passado aos procedimentos remotos */

struct operands
{
        int x;
        int y;
};

/* Definição da interface que será oferecida aos clientes */

program CALC_PROG
{
   version CALC_VERSION
   {
     int ADD (operands) = 1;
   }
   = VERSION_NUMBER;
}
= PROGRAM_NUMBER;	