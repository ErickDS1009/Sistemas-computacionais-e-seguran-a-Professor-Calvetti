package calvetti;
import java.io.File;
public class TesteCrypto {
    public static void main(String[] args) throws Exception {
        String sMsgClara = "Oi, Alunos do IMT";
        String sMsgCifrada = null;
        String sMsgDecifrada = null;
        byte[] bMsgClara = null;
        byte[] bMsgCifrada = null;
        byte[] bMsgDecifrada = null;
        //Instancia objeto da classe Impressora
        Impressora prn = new Impressora();
        //Imprime marcador de bloco
        System.out.println("--------------------------------------------------------------");
        //imprime texto
        System.out.println(">>>imprimindo mensagem original...");
        System.out.println("");
        //Converte o teexto String dado no equivalentet byte []
        bMsgClara = sMsgClara.getBytes("ISO-8859-1");
        //Imprime cabecalho da mensagem
        System.out.println("Mensagem Clara (Hexadecimal):");
        //Imprime o texto original em Hexagonal
        System.out.println(prn.hexBytesToString(bMsgClara));
        System.out.println("");
        //Imprime cabecalho da mensagem
        System.out.println("Mensagem Clara (String):");
        //Imprime o texto original em String
        System.out.println(sMsgClara);
        System.out.println("");
        /*
         * criptografia Dummy----------------------------------------------------------------
         */
        //Imprime texto
        System.out.println(">>>Cifrando com o Algoritmo Dummy...");
        System.out.println("");
        //Instancia um objeto da classe CryptoDummy
        CryptoDummy cdummy = new CryptoDummy();
        //Gera a chave criptografica Dummy simetrica e nome do arquivo onde sera armazenado
        cdummy.geraChave( new File ("chave.dummy"));
        //Gera a chave Dummy da mensagem dada,com a chave Dummy simetrica dada
        cdummy.geraCifra(bMsgClara, new File ("chave.dummy"));
        //Recebe o texto cifrado
        bMsgCifrada = cdummy.getTextoCifrado();
        //Converte o texto byte[] no equivalente String
        sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
        //Imprime cabecalho da mensagem
        System.out.println("Mensagem Cifrada (Hexadecimal):");
        //Imprime o texto cifrado em Hexadecimal
        System.out.println(prn.hexBytesToString(bMsgCifrada));
        System.out.println("");
        //Imprime cabecalho da mensagem
        System.out.println("Mensagem Cifrada (String):");
        //Imprime o texto cifrado em String
        System.out.println(sMsgCifrada);
        System.out.println("");
        //Imprime texto
        System.out.println(">>>Decifrando com o Algoritmo Dummy");
        System.out.println("");
        //Gera a decifra Dummy da mensagem dada, segundo a chave Dummy simetrica gerada
        cdummy.geraDecifra(bMsgCifrada, new File ("chave.dummy"));
        //Recebe o texto decifrado
        bMsgDecifrada = cdummy.getTextoDecifrado();
        //Converte o texto bity[] no equivalente String
        sMsgDecifrada = (new String (bMsgDecifrada, "ISO-8859-1"));
        //Imprime cabecalho da mensagem
        System.out.println("Mensagem Decifrada (Hexadecimal):");
        //Imprime o texto decifrado em Hexadeciaml
        System.out.println(prn.hexBytesToString(bMsgDecifrada));
        System.out.println();
        //Imprime o cabecalho da mensagem
        System.out.println("Mensagem Decifrada (String):");
        //Imprime o texto decifrado em String
        System.out.println(sMsgDecifrada);
        System.out.println("");
        /*
        * criptografia Dummy----------------------------------------------------------------
        */
        //Imprime o texto
        System.out.println(">>> Cifrando com Algoritmo AES...");
        System.out.println("");
         //Instancia um objeto da classe CriptoAES
        CryptoAES caes = new CryptoAES();
         //Gera a chave Criptografica AES simetrica e nome do arquivo onde sera armazenada
        caes.geraChave( new File ("chave.simetrica"));
        //Gera a cifra AES da mensagem dada, com a chave Dummy simetrica dada
        caes.geraCifra(bMsgClara, new File ("chave.simetrica"));
        //Recebe o texto cifrado
        bMsgCifrada = caes.getTextoCifrado();
        //Converte o texto byte[] no equivalente String
        sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
        //Imprime cabecalho da mensagem
        System.out.println("Mensagem Cifrada (Hexadecimal) :");
        //Imprime o texto cifrado em Hexadecimal
        System.out.print(prn.hexBytesToString(bMsgCifrada));
        System.out.println("");
        //Imprime cabecalho da mensagem
        System.out.println("Mensagem Cifrada (String) :");
        //Imprime o texto cifrado em String
        System.out.println(sMsgCifrada);
        System.out.println("");
        //Imprime texto
        System.out.println(">>> Decifrando com o algoritimo AES . . .");
        System.out.println("");
        //Gera a decifra AES da mensagem dada, segundo a chave simetrica gerada
        caes.geraDecifra(bMsgCifrada, new File ("chave.simetrica"));
        //recebe o texto decifrado
        bMsgDecifrada = caes.getTextoDecifrado();
        //Converte o texto byte[] no equivalente String
        sMsgDecifrada = (new String (bMsgDecifrada, "ISO-8859-1"));
        //Imprime cabecalho da mensagem
        System.out.println("Mensagem Decifrada (Hexadecimal) :");
        //Imprime o texto Decifrado em Hexadecimal
        System.out.print(prn.hexBytesToString(bMsgDecifrada));
        System.out.println("");
        //Imprime cabecalho da mensagem
        System.out.println("Mensagem Decifrada (String) :");
        //Imprime o texto cifrado em String
        System.out.println(sMsgDecifrada);
        System.out.println("");
        /*
         *  Criptografia RSA-----------------------------------------------------
         */
        // Imprime Texto
        System.out.println(">>> Cifrando com o algoritmo RSA...");
        System.out.println("");
        // Instancia um objeto da classe CryptoRSA
        CryptoRSA crsa = new CryptoRSA();
        // Gera as Chaves criptografica RSA publica e privada e os arquivos onde armazenar
        crsa.geraParDeChaves(new File ("chave.publica"), new File ("chave.privada"));
        // Gera a cifra RSA da mensagem dada, segundo a chave publica gerada
        crsa.geraCifra(bMsgClara, new File ("chave.publica"));
        // Recebe o texto cifrado
        bMsgCifrada = crsa.getTextoCifrado();
        // Converte o texto byte[] no equivalente String
        sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
        // Imprime cabecalho da mensagem
        System.out.println("Mensagem Cifrada (Hexadecimal):");
        // Imprime o texto cifrado em Hexadecimal
        System.out.print(prn.hexBytesToString(bMsgCifrada));
        System.out.println("");
        // Imprime cabecalho da mensagem
        System.out.println("Nensagem Cifrada (String):");
        // Imprime o texto cifrado em String
        System.out.println(sMsgCifrada);
        System.out.println("");
        // Imprime texto
        System.out.println(">>> Decifrando com o algoritmo RSA...");
        System.out.println("");
        // Gera a decifra RSA da mensagem dada, Segundo a chave privada gerada
        crsa.geraDecifra(bMsgCifrada, new File ("chave-privada"));
        // recebe o texto decifrado
        bMsgDecifrada = crsa.getTextoDecifrado();
        // Converte o texto byte[] no equivalente String
        sMsgDecifrada = (new String (bMsgDecifrada, "ISO-8859-1"));
        // Imprime cabecalho da mensagem
        System.out.println("Mensagem Decifrada (Hexadecimal):");
        // Imprime o texto decifrado em Hexadecimal
        System.out.print(prn.hexBytesToString(bMsgDecifrada));
        System.out.println();
        // Imprine cabecalho da mensagem
        System.out.println("Mensagem Decifrada (String):");
        // Imprime o texto decifrado em String
        System.out.println(sMsgDecifrada);
        System.out.println("");
    }
}
