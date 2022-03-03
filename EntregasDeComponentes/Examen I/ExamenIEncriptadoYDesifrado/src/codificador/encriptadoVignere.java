package codificador;

import java.util.Scanner;

public class encriptadoVignere implements Codificador {

    @Override
    public void codificar() {


        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        String mensaje, llave = "";
        System.out.println("Entre el mensaje a encriptar: ");
        mensaje = sc.nextLine();
        System.out.println("Digite la llave: ");
        llave = sc.nextLine();
        System.out.println("Digite 1 para encriptar\nDigite 2 para desencriptar");
        int MenuOpc = in.nextInt();

        switch (MenuOpc) {
            case 1:
                String MensajeE = Encriptar(mensaje, llave);
                System.out.println("El mensaje encriptado es: " + MensajeE);
                break;
            case 2:
                String MensajeD = Desencriptar(mensaje, llave);
                System.out.println("El mensaje desencriptado es: " + MensajeD);
                break;
        }


    }

    public static String Encriptar(String mensaje, String llave) {
        String pMensaje = "";
        mensaje = mensaje.toUpperCase();
        for (int i = 0, j = 0; i < mensaje.length(); i++) {
            char temp = mensaje.charAt(i);
            pMensaje += (char) (((temp - 65) + (llave.charAt(j) - 65)) % 26 + 65);
            j = ++j % llave.length();
        }
        return pMensaje;
    }

    public static String Desencriptar(String mensaje, String llave) {
        String pMensaje = "";
        mensaje = mensaje.toUpperCase();
        for (int i = 0, j = 0; i < mensaje.length(); i++) {
            char temp = mensaje.charAt(i);
            pMensaje += (char) ((temp - llave.charAt(j) + 26) % 26 + 65);
            j = ++j % llave.length();
        }
        return pMensaje;
    }
}
