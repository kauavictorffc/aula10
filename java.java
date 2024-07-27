
interface DatabaseAdapter {
    void connect();
    void executeQuery(String query);
    void disconnect();
}

class ParadoxAdapter implements DatabaseAdapter {
    public void connect() {
        System.out.println("Conectando ao Paradox");
    }

    public void executeQuery(String query) {
        System.out.println("Executando query no Paradox: " + query);
    }

    public void disconnect() {
        System.out.println("Desconectando do Paradox");
    }
}

class FirebirdAdapter implements DatabaseAdapter {
    public void connect() {
        System.out.println("Conectando ao Firebird");
    }

    public void executeQuery(String query) {
        System.out.println("Executando query no Firebird: " + query);
    }

    public void disconnect() {
        System.out.println("Desconectando do Firebird");
    }
}

class MySQLAdapter implements DatabaseAdapter {
    public void connect() {
        System.out.println("Conectando ao MySQL");
    }

    public void executeQuery(String query) {
        System.out.println("Executando query no MySQL: " + query);
    }

    public void disconnect() {
        System.out.println("Desconectando do MySQL");
    }
}

class DatabaseClient {
    private DatabaseAdapter adapter;

    public DatabaseClient(String userProfile) {
        this.adapter = getAdapter(userProfile);
    }

    private DatabaseAdapter getAdapter(String userProfile) {
        switch (userProfile) {
            case "Gratuito":
                return new ParadoxAdapter();
            case "Básico":
                return new FirebirdAdapter();
            case "Ultimate":
                return new MySQLAdapter();
            default:
                throw new IllegalArgumentException("Perfil de usuário inválido");
        }
    }

    public void runQuery(String query) {
        adapter.connect();
        adapter.executeQuery(query);
        adapter.disconnect();
    }

    public static void main(String[] args) {
        String userProfile = "Ultimate"; // Pode ser "Gratuito", "Básico" ou "Ultimate"
        DatabaseClient client = new DatabaseClient(userProfile);
        client.runQuery("SELECT * FROM tabela");
    }
}
