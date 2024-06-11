import java.util.Scanner;

public class CronometroUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op;

        int qtdCron = 0;
        final int MAX = 3;
        Cronometro cronometros[] = new Cronometro[MAX];

        do {
            System.out.println("------Cronometros------");
            System.out.println("Op 1: Iniciar novo cronometro");
            System.out.println("Op 2: Consultar um cronometro");
            System.out.println("Op 3: Consultar todos os cronometro");
            System.out.println("Op 4: Encerrar");
            System.out.print("..: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    if (qtdCron == MAX) {
                        System.out.println("Numero maximo de cronometros atingido");
                    } else {
                        cronometros[qtdCron] = new Cronometro(false);
                        cronometros[qtdCron].start();
                        qtdCron++;
                        System.out.println("Novo cronometro iniciado");
                    }
                    break;

                case 2:
                    if (qtdCron == 0) {
                        System.out.println("Nao existem cronometros iniciados");
                    } else {
                        System.out.println("Qual cronometro voce quer consultar? 1-" + qtdCron);
                        System.out.print("..: ");
                        int resp;
                        resp = scanner.nextInt();

                        if(resp > qtdCron){
                            System.out.println("Cronometro invalido");
                        }
                        else {
                            System.out.println("Cronometro " + resp + ": " + cronometros[resp - 1].getContador());
                        }
                    }
                    break;

                case 3:
                    if (qtdCron == 0) {
                        System.out.println("Nao existem cronometros iniciados");
                    } else {
                        for (int i = 0; i < qtdCron; i++) {
                            System.out.println("Cronometro " + (i + 1) + ": " + cronometros[i].getContador());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Encerrando...");
                    System.exit(0);
                break;


                default:
                System.out.println("Opcao invalida");
                break;

            }
        }
        while (op != 4);

        scanner.close();
    }
}
