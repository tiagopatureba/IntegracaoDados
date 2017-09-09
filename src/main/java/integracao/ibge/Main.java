package integracao.ibge;

public class Main {

    public static void main(String[] args) {
        FileReader file = new FileReader();
        file.limpaDados("municipios");
        file.limpaDados("unidades_federativas");
        file.limpaDados("atividades_bases");
        file.limpaDados("regioes_geograficas");
        //file.insertIntoTableFromFile("data/unidades_federativas.csv", "insertUnidadesFederativas");
        //file.insertIntoTableFromFile("data/municipios.csv", "insertMunicipios");
        //file.insertIntoTableFromFile("data/atividades_bases.csv", "insertAtividadesBases");
        //file.insertIntoTableFromFile("data/regioes_geograficas.csv", "insertRegioesGeograficas");
    }
}
