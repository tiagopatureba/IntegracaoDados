package integracao.ibge;

public class Main {

    public static void main(String[] args) {
        FileReader file = new FileReader();
        file.limpaDados("municipios_codigos");
        file.limpaDados("unidades_federativas");
        file.limpaDados("atividades_bases");
        file.insertIntoTableFromFile("data/unidades_federativas.csv", "insertUnidadesFederativas");
        file.insertIntoTableFromFile("data/municipios_codigos_go.csv", "insertMunicipio");
        file.insertIntoTableFromFile("data/atividades_bases.csv", "insertAtividadesBases");
    }
}
