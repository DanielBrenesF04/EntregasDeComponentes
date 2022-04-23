import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class DemoApplication {
    static Scanner sc = new Scanner(System.in);
    private static final Logger log;

    static {

        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log = Logger.getLogger(DemoApplication.class.getName());
    }

    public static void main(String[] args) throws Exception {
        log.info("Loading application properties");
        Properties properties = new Properties();
        properties.load(DemoApplication.class.getClassLoader().getResourceAsStream("application.properties"));

        log.info("Connecting to the database");
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
        log.info("Database connection test: " + connection.getCatalog());

        log.info("Create database schema");
        Scanner scanner = new Scanner(DemoApplication.class.getClassLoader().getResourceAsStream("schema.sql"));
        Statement statement = connection.createStatement();
        while (scanner.hasNextLine()) {
            statement.execute(scanner.nextLine());
        }

        int menuOpc;

        do {
            System.out.println("Digite 1 para usar el servicio de tiquetes\nDigite 2 para usar el servicio de membresias");
            menuOpc = sc.nextInt();
            switch (menuOpc){
                case 1:
                    menuTiquetes(connection);
                    break;
                case 2:
                    menuMembresia(connection);
                    break;
            }
        }while (menuOpc != 0 );



        log.info("Closing database connection");
        connection.close();
    }

    public static void menuTiquetes(Connection connection) throws SQLException {
        Tiquete tiquete = new Tiquete();
        long id;
        int menuOpc,num;
        String NP,SP,AS;
        System.out.println("Menu de tiquetes\nDigite 1 para registrar un tiquete\n" +
                "Digite 2 para consultar un tiquete por ID\nDigite 3 para editar un tiquete\nDigite 4 para borrar un tiquete ");


        menuOpc = sc.nextInt();
        do {
            switch (menuOpc) {
                case 1:
                    System.out.println("Digite el id");
                    id = sc.nextLong();
                    System.out.println("Digite el nombre de la pelicula");
                    NP = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Digite la sala de la pelicula");
                    SP = sc.nextLine();
                    System.out.println("Digite digite el asiento de la sala");
                    AS = sc.nextLine();


                    tiquete = new Tiquete(id,NP,SP,AS);
                    insertTiquete(tiquete,connection);
                    readTiquetebyId(1,connection);

                    break;
                case 2:
                    System.out.println("Digite el tiquete a consultar por ID");
                    num = sc.nextInt();
                    tiquete = readTiquetebyId(num, connection);

                    break;
                case 3:
                    System.out.println("Digite el id");
                    id = sc.nextLong();
                    System.out.println("Digite el nombre de la pelicula");
                    NP = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Digite la sala de la pelicula");
                    SP = sc.nextLine();
                    System.out.println("Digite digite el asiento de la sala");
                    AS = sc.nextLine();

                    tiquete.setId(id);
                    tiquete.setNombrePelicula(NP);
                    tiquete.setSala(SP);
                    tiquete.setAsiento(AS);
                    updateTiquete(tiquete,connection);
                    tiquete =readTiquete(connection);
                    break;
                case 4:
                    System.out.println("Digite el tiquete a borrar por ID");
                    num = sc.nextInt();
                    deleteTiquete(num,tiquete,connection);
                    break;
            }
            break;
        }while (menuOpc != 0);

    }

    public static void menuMembresia(Connection connection) throws  SQLException{
        Membresia membresia = new Membresia();
        long id;
        String ND,Cedula;
        int PD,NM,P,menuOpc,num;
        System.out.println("Menu de tiquetes\nDigite 1 para registrar una membresia\n" +
                "Digite 2 para consultar una memebresia por ID\nDigite 3 para editar la membresia\nDigite 4 para borrar una membresia ");

        menuOpc = sc.nextInt();
        do {
            switch (menuOpc) {
                default:
                    System.out.println("Opcion invalida");
                    break;
                case 1:
                    System.out.println("Digite el id");
                    id = sc.nextLong();
                    System.out.println("Digite el nombre del dueño de la tarjeta");
                    ND = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Digite la cedula del dueño");
                    Cedula = sc.nextLine();
                    System.out.println("Digite el porcentaje de descuento en compras");
                    PD = sc.nextInt();
                    System.out.println("Digite el nivel de membresia");
                    NM = sc.nextInt();

                    membresia = new Membresia(id,ND,Cedula,PD,NM,0);
                    insertarMembresia(membresia,connection);
                    break;
                case 2:
                    System.out.println("Digite la membresia a consultar por ID");
                    num = sc.nextInt();
                    membresia = readMembresiaId(num, connection);

                    break;
                case 3:
                    System.out.println("Digite el id");
                    id = sc.nextLong();
                    System.out.println("Digite el nombre del dueño de la tarjeta");
                    ND = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Digite la cedula del dueño");
                    Cedula = sc.nextLine();
                    System.out.println("Digite el porcentaje de descuento en compras");
                    PD = sc.nextInt();
                    System.out.println("Digite el nivel de membresia");
                    NM = sc.nextInt();
                    System.out.println("Digite los puntos de la tarjeta");
                    P = sc.nextInt();

                    membresia.setId(id);
                    membresia.setNombreDuenno(ND);
                    membresia.setCedula(Cedula);
                    membresia.setPorcentajeDescuento(PD);
                    membresia.setNivelMiembro(NM);
                    membresia.setPuntos(P);

                    updateMembresia(membresia,connection);
                    break;
                case 4:
                    System.out.println("Digite la membresia a borrar por ID");
                    num = sc.nextInt();
                    deleteMembresia(num,membresia,connection);
                    break;
            }
            break;
        }while (menuOpc != 0);
    }



    private static void insertTiquete(Tiquete tiquete, Connection connection) throws SQLException {
        log.info("Insert Tiquete");
        PreparedStatement insertStatement = connection.
                prepareStatement("INSERT INTO Tiquete(id,NombrePelicula,Sala,Asiento)VALUES (?, ?, ?, ?);");

        insertStatement.setLong(1, tiquete.getId());
        insertStatement.setString(2, tiquete.getNombrePelicula());
        insertStatement.setString(3, tiquete.getSala());
        insertStatement.setString(4, tiquete.getAsiento());
        insertStatement.executeUpdate();
    }

    private static Tiquete readTiquete(Connection connection) throws SQLException {
        log.info("Read data");
        int num = 1;
        PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM Tiquete;");
        ResultSet resultSet = readStatement.executeQuery();
        if (!resultSet.next()) {
            log.info("La base de datos esta vacia");
            return null;
        }
        log.info("Primer elemento en cola");
        Tiquete tiquete = new Tiquete();
        tiquete.setId(resultSet.getLong("id"));
        tiquete.setNombrePelicula(resultSet.getString("NombrePelicula"));
        tiquete.setSala(resultSet.getString("Sala"));
        tiquete.setAsiento(resultSet.getString("Asiento"));
        log.info("Informacion de la base de datos: " + tiquete.toString());
        return tiquete;
    }

    private static Tiquete readTiquetebyId(int num, Connection connection) throws SQLException {
        log.info("Read data");
        PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM Tiquete WHERE id =" + num);
        ResultSet resultSet = readStatement.executeQuery();
        if (!resultSet.next()) {
            log.info("La base de datos esta vacia");
            return null;
        }
        Tiquete tiquete = new Tiquete();
        tiquete.setId(resultSet.getLong("id"));
        tiquete.setNombrePelicula(resultSet.getString("NombrePelicula"));
        tiquete.setSala(resultSet.getString("Sala"));
        tiquete.setAsiento(resultSet.getString("Asiento"));
        log.info("Informacion de la base de datos: " + tiquete.toString());
        return tiquete;
    }

    private static void updateTiquete(Tiquete tiquete, Connection connection) throws SQLException {
        log.info("Update tiquete");
        PreparedStatement updateStatement = connection
                .prepareStatement("UPDATE tiquete SET id= ?,NombrePelicula =?,Sala =? ,Asiento=? ");
        updateStatement.setLong(1, tiquete.getId());
        updateStatement.setString(2, tiquete.getNombrePelicula());
        updateStatement.setString(3, tiquete.getSala());
        updateStatement.setString(4, tiquete.getAsiento());
        updateStatement.executeUpdate();
    }

    private static void deleteTiquete(int num,Tiquete tiquete, Connection connection) throws SQLException {
        log.info("Borrar Tiquete");

        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM Tiquete WHERE id = "+num);
        deleteStatement.executeUpdate();

    }



    private static void insertarMembresia(Membresia membresia, Connection connection) throws SQLException {
        log.info("Insert Membresia");
        PreparedStatement insertStatement = connection.
                prepareStatement("INSERT INTO Membresia(id,NombreDuenno,Cedula,PorcentajeDescuento,NivelMiembro,Puntos)" +
                        "VALUES (?, ?, ?, ?, ?, ?);");

        insertStatement.setLong(1, membresia.getId());
        insertStatement.setString(2, membresia.getNombreDuenno());
        insertStatement.setString(3, membresia.getCedula());
        insertStatement.setInt(4, membresia.getPorcentajeDescuento());
        insertStatement.setInt(5, membresia.getNivelMiembro());
        insertStatement.setInt(6, membresia.getPuntos());
        insertStatement.executeUpdate();
        readMembresia(connection);
    }

    private static Membresia readMembresia(Connection connection) throws SQLException {
        log.info("Read data");
        PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM Membresia;");
        ResultSet resultSet = readStatement.executeQuery();
        if (!resultSet.next()) {
            log.info("La base de datos esta vacia");
            return null;
        }
        log.info("Primer elemento en cola");

        Membresia membresia = new Membresia();
        membresia.setId(resultSet.getLong("id"));
        membresia.setNombreDuenno(resultSet.getString("NombreDuenno"));
        membresia.setCedula(resultSet.getString("Cedula"));
        membresia.setPorcentajeDescuento(resultSet.getInt("PorcentajeDescuento"));
        membresia.setNivelMiembro(resultSet.getInt("NivelMiembro"));
        membresia.setPuntos(resultSet.getInt("Puntos"));

        log.info("Informacion de la base de datos: " + membresia.toString());

        return membresia;
    }

    private static Membresia readMembresiaId(int num, Connection connection) throws SQLException {
        log.info("Read data");
        PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM Membresia WHERE id =" + num);
        ResultSet resultSet = readStatement.executeQuery();
        if (!resultSet.next()) {
            log.info("La base de datos esta vacia");
            return null;
        }
        log.info("Primer elemento en cola");

        Membresia membresia = new Membresia();
        membresia.setId(resultSet.getLong("id"));
        membresia.setNombreDuenno(resultSet.getString("NombreDuenno"));
        membresia.setCedula(resultSet.getString("Cedula"));
        membresia.setPorcentajeDescuento(resultSet.getInt("PorcentajeDescuento"));
        membresia.setNivelMiembro(resultSet.getInt("NivelMiembro"));
        membresia.setPuntos(resultSet.getInt("Puntos"));

        log.info("Informacion de la base de datos: " + membresia.toString());
        return membresia;
    }

    private static void updateMembresia(Membresia membresia, Connection connection) throws SQLException {
        log.info("Update Membresia");
        PreparedStatement updateMembresia = connection
                .prepareStatement("UPDATE Membresia SET id= ?,NombreDuenno =?,Cedula =? ,PorcentajeDescuento=?," +
                        " NivelMiembro =?,Puntos=?");
        updateMembresia.setLong(1, membresia.getId());
        updateMembresia.setString(2, membresia.getNombreDuenno());
        updateMembresia.setString(3, membresia.getCedula());
        updateMembresia.setInt(4, membresia.getPorcentajeDescuento());
        updateMembresia.setInt(5, membresia.getNivelMiembro());
        updateMembresia.setInt(6, membresia.getPuntos());
        updateMembresia.executeUpdate();
        readMembresia(connection);
    }

    private static void deleteMembresia(int num,Membresia membresia, Connection connection) throws SQLException {
        log.info("Borrar Membresia");

        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM Membresia WHERE id = "+num);
        deleteStatement.executeUpdate();
        readMembresia(connection);

    }
}





