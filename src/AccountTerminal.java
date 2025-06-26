import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AccountTerminal {
    public static void main(String[] args) {
        //TODO: Conhecer e importar a classe Scanner
        //Exibir mensagens para o usuário
        //Obter pelo scanner os valores digitados pelo terminal
        //Exibir a mensagem final conta criada

        List <String> userData = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean accountHasCreated = false;

        while (true){
            if(!accountHasCreated){
                System.out.print("\nSistema Registro");
                System.out.print("\nDigite um usuario: ");
                String _userAccount = sc.nextLine();
                userData.add(_userAccount);
                System.out.println("\nDigite uma senha:");
                String _password = sc.nextLine();
                userData.add(_password);
                accountHasCreated = true;
                System.out.println(_userAccount);
                System.out.println(_password);
            }
            else{
                System.out.print("\nSistema Login");
                while (true) {
                    System.out.print("\nDigite um usuario: ");
                    String userAccountTemp = sc.nextLine();
                    if(userAccountTemp.equals(userData.get(0))){
                        break;
                    }
                    else{
                        System.out.print("\nUsuário não existe!");
                    }
                }
                while (true) {
                    System.out.print("\nDigite a senha: ");
                    String passwordTemp = sc.nextLine();
                    if(passwordTemp.equals(userData.get(1))){
                        accountInterface();
                        break;
                    }
                    else{
                        System.out.print("\nSenha Errada!");
                    }
                }
                break;
            }
        }

    }

    public static void accountInterface(){
        Scanner sc = new Scanner(System.in);

        float currentBalance = 0.0f;

        while (true){
            System.out.print("\nSeja bem-vindo a sua conta.");
            System.out.print("\n1 - Ver Saldo");
            System.out.print("\n2 - Depositar");
            System.out.print("\n3 - Sacar");
            System.out.print("\n4 - Sair");
            System.out.print("\nDigite: ");
            int choiceUser = sc.nextInt();
            if(choiceUser == 1){
                System.out.printf("R$%s", currentBalance);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else if(choiceUser == 2){
                System.out.println("\nQuanto você quer depositar?: R$");
                float depositAmount = sc.nextFloat();
                currentBalance += depositAmount;
                System.out.println("\nDepositado!");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else if(choiceUser == 3){
                while (true){
                    System.out.println("\nQuanto você quer sacar?: R$");
                    float withdrewAmount = sc.nextFloat();
                    if(withdrewAmount  <= currentBalance){
                        currentBalance -= withdrewAmount;
                        System.out.println("\nSaque realizado com sucesso!");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                    else{
                        System.out.println("\nSaque recusado!");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                }
            }else if(choiceUser == 4){
                System.out.print("\nPrograma encerrado.");
                break;
            }
            else{
                System.out.print("\nOpção não encontrada!");
            }

        }
    }
}
