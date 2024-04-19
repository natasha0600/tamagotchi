package tamagotchi_;//CLASSE DESENVOLVIDA POR KELLY NATASHA DE OLIVEIRA FERNANDES//

public class Principal{
    public static void main (String [] args){
        Tamagotchi tamagotchiPrincipal = new Tamagotchi(Teclado.leString("Digite o nome de seu Tamagotchi"), 0, 1,true, 0);
        tamagotchiPrincipal.imprimeInfo();
        
        boolean vivo = true;//coloquei este boolean aqui para ele verificar no while se está vivo
        
        while (vivo){
            double escolhaPrincipal = (Math.random ()*3 + 1);
        
            int escolha = (int)escolhaPrincipal;  //coloquei o int para ele escolher aleatoriamente, um número de 1 a 3, inteiros, que serão sorteados conforma: escolha ==1 serão as ações para o sono, a escolha==2 serão as ações para a fome e a escolha==3 serão as ações para o tédio do Tamagotchi.
            
            //criando os if's para as escolhas, esse é o do sono do Tamagotchi
            if (escolha==1){ 
                int sono= Teclado.leInt("Hora de nanar\nO que você deseja fazer? Dormir ou ficar acordado?\nEscolha 1 para dormir ou 2 para deixá-lo acordado");
                if(sono==1){
                    tamagotchiPrincipal.setvezesAcordado(0);
                    tamagotchiPrincipal.setIdade(tamagotchiPrincipal.getIdade() + 1); //foi pêgo o set para alterar o valor e o get para pegar o valor que já possui, para adicionar com o valor que deve ser adicionado conforme as regras do jogo, fiz isso em todos os if's
                    System.out.println("Você escolheu a opção dormir, agora ele está dormindo zzzzzZZZZZzzzZZZ");
                    tamagotchiPrincipal.imprimeInfo();//chamando o método que imprime as informações e as atualiza, chamei em todas as escolhas deste if e dos outros
                }
                if(sono==2){
                    System.out.println("Você escolheu a opção ficar acordado, vamos virar a nooiteeee uhuuulllll");
                    tamagotchiPrincipal.setvezesAcordado(tamagotchiPrincipal.getvezesAcordado() + 1);
                    tamagotchiPrincipal.imprimeInfo();
                    if(tamagotchiPrincipal.getvezesAcordado()==5){
                        tamagotchiPrincipal.setvezesAcordado(0);
                        System.out.println("Seu pet ficou muitas vezes acordado, está cansadinho e agora foi dormir zzZZZZzzzz");
                    }
                }
                if (sono!=1 && sono!=2){
                    System.out.println(" ERRO, ESCOLHA UMA OPÇÃO VÁLIDA!!!  ");//este if aqui, é para o caso do usuário escolher uma opção diferente das informadas, fiz um if assim para todas as escolhas 
                }
            }
            //este if é para a fome do Tamagotchi
            if (escolha==2){
                int fome=Teclado.leInt("Seu pet está com a barriguinha roncando, brrrrrruuuuuuu!\nDigite 1 para Comer Muito, 2 para Comer Pouco ou 3 para Não Comer");
                if(fome==2){
                    tamagotchiPrincipal.setPeso(tamagotchiPrincipal.getPeso()+1); 
                    System.out.println("Você escolheu a opção de comer pouco, que delícia esse rango, nham nham nhaaaammmm!");
                    tamagotchiPrincipal.imprimeInfo();
                }
                if (fome==1){
                    tamagotchiPrincipal.setPeso(tamagotchiPrincipal.getPeso()+5);
                    tamagotchiPrincipal.setvezesAcordado(0); //aqui é pra zerar o contador do sono
                    tamagotchiPrincipal.setIdade(tamagotchiPrincipal.getIdade() + 1); //aqui é para contar um dia de vida, pois quando ele come muito, dorme, e quando dorme ganha um dia de  vida
                    System.out.println("Você escolheu a opção de comer muito e agora ele foi dormir de tanto que comeu, comer e depois tirar uma sonequinha é bom né?");
                    tamagotchiPrincipal.imprimeInfo();
                    if (fome==1 && tamagotchiPrincipal.getPeso()>9){ //aqui eu coloquei este if, para quando chegar em 9 ou mais, ele avisar que o pet está comendo demais
                        System.out.println("***Tenha cuidado,pois seu pet está comendo demais!!!!🍔***"); 
                    }
                }
                if (fome==3){
                   System.out.println("Você escolheu a opção de não comer e ele emagreceu 2kg, pobrezinho, ficou com fome :("); 
                   tamagotchiPrincipal.setPeso(tamagotchiPrincipal.getPeso()-2);
                   tamagotchiPrincipal.imprimeInfo();
                   
                }
                if (fome!=1 && fome!=2 && fome!=3){
                    System.out.println(" ERRO, ESCOLHA UMA OPÇÃO VÁLIDA!!!   ");
                }
            }
            //este é para o tédio do Tamagotchi
            if (escolha==3){
                int tedio = Teclado.leInt("  Seu pet está entediado 😒?\nVamos brincar com ele? Você pode optar por Correr ou Caminhar.\nDigite 1 para Correr ou 2 para Caminhar  ");
                if (tedio==1){
                   System.out.println(" Você escolheu a opção de correr, ele agora perdeu 4kg e está comendo muito,e quando ele come muito o que ele e a maioria de nós faz? Ele dorme :D Fazer exercícios dá uma fome e um soninho né?  ");
                   tamagotchiPrincipal.setPeso(tamagotchiPrincipal.getPeso()-4+5);//coloquei aqui que é -4+5, pois quando ele corre, ele perde 4kg mas come muito e quando ele come muito ele engorda 5 kg.
                   tamagotchiPrincipal.setvezesAcordado(0);//zerei o contador do sono aqui, pois se ele correu e comeu muito, quando come muito ele dorme
                   tamagotchiPrincipal.setIdade(tamagotchiPrincipal.getIdade()+1);//aumentei um dia de vida dele aqui pois, se ele dorme, ele ganha um dia de vida
                   tamagotchiPrincipal.imprimeInfo();
                }
                if (tedio==2){
                    System.out.println(" Você escolheu a opção de caminhar, fazer exercícios é bom né?  ");
                    tamagotchiPrincipal.setPeso(tamagotchiPrincipal.getPeso()-1);
                    tamagotchiPrincipal.imprimeInfo();
                }
                if (tedio!=1 && tedio!=2){
                    System.out.println(" ERRO, ESCOLHA UMA OPÇÃO VÁLIDA!!!  ");
                }
            }
            //agora os if's para verificarem se o Tamagotchi está vivo ou não
            if (tamagotchiPrincipal.getPeso() >20 ){    
                System.out.println(" Infelizmente seu Tamagotchi morreu de tanto comer e explodiu! É necessário ter mais cuidado,tenha mais responsabilidade com o pet da próxima vez! ");
                vivo = false;
            }
            if (tamagotchiPrincipal.getPeso() <=0){   
                System.out.println("  Infelizmente seu Tamagotchi morreu de desnutrição 😿. Muito triste e por isso você precisa ter mais atenção da próxima vez, cuide para que não aconteça de novo! ");
                vivo = false;
            
            }
            if (tamagotchiPrincipal.getIdade() ==15){  
                System.out.println("  Infelizmente seu Tamagotchi morreu de velhice. Acredito que vocês tenham passado esses 15 dias com muita felicidade e brincadeiras. Com certeza seu Tamagotchi gostou muito de você <3");
                vivo = false;
            }
        }
    }   
}