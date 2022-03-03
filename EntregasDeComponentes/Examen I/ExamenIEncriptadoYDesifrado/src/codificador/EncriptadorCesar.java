package codificador;

import java.util.Scanner;

public class EncriptadorCesar implements Codificador {
    @Override
    public void codificar() {
        Scanner sc = new Scanner(System.in);
        String mensaje = "";
        int llave;
        System.out.println("Entre el mensaje a encriptar: ");
        mensaje = sc.nextLine();
        System.out.println("Digite la llave: ");
        llave = sc.nextInt();

        System.out.println("Digite 1 para encriptar\nDigite 2 para desencriptar");
        int MenuOpc;
        MenuOpc = sc.nextInt();
        switch (MenuOpc) {
            case 1:
                encriptar(mensaje, llave);
                break;
            case 2:
                desencriptar(mensaje, llave);
                break;
        }
    }

    public void encriptar(String mensaje, int llave) {
        char temp = 0;
        String MensajeEncriptado = "";
        for (int i = 0; i < mensaje.length(); ++i) {
            temp = mensaje.charAt(i);
            if (temp >= 'a' && temp <= 'z') {
                temp = (char) (temp + llave);

                if (temp > 'z') {
                    temp = (char) (temp - 'z' + 'a' - 1);
                }

                MensajeEncriptado += temp;
            } else if (temp >= 'A' && temp <= 'Z') {
                temp = (char) (temp + llave);

                if (temp > 'Z') {
                    temp = (char) (temp - 'Z' + 'A' - 1);
                }

                MensajeEncriptado += temp;
            } else {
                MensajeEncriptado += temp;
            }
        }
        System.out.println("Mensaje Encriptado = " + MensajeEncriptado);
    }

    public static void desencriptar(String mensaje, int llave) {
        char temp = 0;
        String MensajeDesencriptado = "";
        for (int i = 0; i < mensaje.length(); ++i) {
            temp = mensaje.charAt(i);
            if (temp >= 'a' && temp <= 'z') {
                temp = (char) (temp - llave);

                if (temp < 'a') {
                    temp = (char) (temp + 'z' - 'a' + 1);
                }

                MensajeDesencriptado += temp;
            } else if (temp >= 'A' && temp <= 'Z') {
                temp = (char) (temp - llave);

                if (temp < 'A') {
                    temp = (char) (temp + 'Z' - 'A' + 1);
                }

                MensajeDesencriptado += temp;
            } else {
                MensajeDesencriptado += temp;
            }
        }
        System.out.println("Mensaje Desencriptado = " + MensajeDesencriptado);
    }
}
