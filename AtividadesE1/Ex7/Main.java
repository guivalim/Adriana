import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lerNota = new Scanner(System.in);

        System.out.println("Olá aluno, vamos calcular sua média com suas notas de atividades mais a nota de Api. \nObs. Em notas com casas decimais, use virgula e não ponto.");
        System.out.println();

        double p1;

        do {
            System.out.println("Digite a nota da P1, de 0 a 10: ");
            if (lerNota.hasNextDouble()){
                p1 = lerNota.nextDouble();
            } else {
                System.out.println("Erro, digite apenas números.");
                lerNota.next();
                p1 = -1;
            }
        } while (p1 < 0 || p1 > 10);

        double e1;

        do {
            System.out.println("Digite a nota da E1, de 0 a 10: ");
            if (lerNota.hasNextDouble()){
                e1 = lerNota.nextDouble();
            } else {
                System.out.println("Erro, digite apenas números.");
                lerNota.next();
                e1 = -1;
            }
        } while (e1 < 0 || e1 > 10);

        double e2;

        do {
            System.out.println("Digite a nota da E2, de 0 a 10: ");
            if (lerNota.hasNextDouble()){
                e2 = lerNota.nextDouble();
            } else{
                System.out.println("Erro, digite apenas números.");
                lerNota.next();
                e2 = -1;
            }
        } while (e2 < 0 || e2 > 10);


        double x;

        do {
            System.out.println("Digite a nota das atividades extras, de 0 a 2:");
            if (lerNota.hasNextDouble()) {
                x = lerNota.nextDouble();
            }else {
                System.out.println("Erro, digite apenas números.");
                lerNota.next();
                x = -1;
            }
        } while (x < 0 || x > 2);

        double sub;

        do {
            System.out.println("Digite a nota da prova substitutiva, de 0 a 10:");
            if(lerNota.hasNextDouble()) {
                sub = lerNota.nextDouble();
            } else {
                System.out.println("Erro, digite apenas números.");
                lerNota.next();
                sub = -1;
            }
        } while (sub < 0 || sub > 10);

        double api;

        do {
            System.out.println("Digite a nota da Api: ");
            if(lerNota.hasNextDouble()) {
                api = lerNota.nextDouble();
            } else {
                System.out.println("Erro, digite apenas números.");
                lerNota.next();
                api = -1;
            }
        } while (api < 0 || api > 10);

        lerNota.close();

        double mediaAtividades= ((p1*0.5) + (e1*0.2) + (e2*0.3) + x + (sub*0.15));

        mediaAtividades = Math.min(mediaAtividades, 10); //Math.min(a, b) é um método da classe Math do Java que retorna o menor valor entre a e b.

        /*
        É a mesma coisa que isso, só que mais curta:
         if (mediaAtividades>10){
            mediaAtividades =10
        }
        */


        if (mediaAtividades <= 5.9){
            System.out.printf("Você não atingiu a pontuação para a API ser considerada, então sua média foi: %.2f\n", (mediaAtividades*0.50));

        }else{
            double mediaFinal= ((mediaAtividades*0.50) + (api*0.50));
            System.out.printf("Sua média final foi: %.2f\n", mediaFinal);

        }

    }

}
