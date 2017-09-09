package integracao.ibge;

public class Main {

    public static void main(String[] args) {
        FileReader file = new FileReader();
        //
        //
        //
        file.limpaDados("adequacoes_moradias");
        file.limpaDados("atividades_bases");
        file.limpaDados("atividades_cnae_bases");
        file.limpaDados("atividades_cnae_gerais");
        file.limpaDados("atividades_cnae_principais");
        file.limpaDados("atividades_gerais");
        file.limpaDados("atividades_principais");
        file.limpaDados("automoveis");
        file.limpaDados("canalizacoes_abastecimentos_aguas");
        file.limpaDados("celulares");
        file.limpaDados("condicoes_ocupacoes");
        file.limpaDados("cores_racas");
        file.limpaDados("cursos_superiores_bases");
        file.limpaDados("cursos_superiores_gerais");
        file.limpaDados("cursos_superiores_principais");
        file.limpaDados("destinos_lixos");
        file.limpaDados("dificuldades_permanentes_enxegar_ouvir_caminhar_subir_degrau");
        file.limpaDados("doutorados_bases");
        file.limpaDados("doutorados_gerais");
        file.limpaDados("doutorados_principais");
        file.limpaDados("entrevistados");
        file.limpaDados("esgotamentos_sanitarios");
        file.limpaDados("especies");
        file.limpaDados("especies_unidades_visitadas");
        file.limpaDados("existencias_energias_eletricas");
        file.limpaDados("falecimentos_entre_datas");
        file.limpaDados("formas_abastecimentos_aguas");
        file.limpaDados("formas_declarar_idades");
        file.limpaDados("geladeiras");
        file.limpaDados("maquinas_lavar_roupa");
        file.limpaDados("marcas_imputacoes");
        file.limpaDados("medidores_relogios_energia");
        file.limpaDados("municipios");
        file.limpaDados("regioes_geograficas");
        file.limpaDados("unidades_federativas");

        file.insertIntoTableFromFile("data/adequacoes_moradias.csv", "insertAdequacoesMoradias");
        file.insertIntoTableFromFile("data/atividades_bases.csv", "insertAtividadesBases");
        file.insertIntoTableFromFile("data/atividades_cnae_bases.csv", "insertAtividadesCnaeBases");
        file.insertIntoTableFromFile("data/atividades_cnae_gerais.csv", "insertAtividadesCnaeGerais");
        file.insertIntoTableFromFile("data/atividades_cnae_principais.csv", "insertAtividadesCnaePrincipais");
        file.insertIntoTableFromFile("data/atividades_gerais.csv", "insertAtividadesGerais");
        file.insertIntoTableFromFile("data/atividades_principais.csv", "insertAtividadesPrincipais");
        file.insertIntoTableFromFile("data/automoveis.csv", "insertAutomoveis");
        file.insertIntoTableFromFile("data/canalizacoes_abastecimentos_aguas.csv", "insertCanalizacoesAbastecimentosAguas");
        file.insertIntoTableFromFile("data/celulares.csv", "insertCelulares");
        file.insertIntoTableFromFile("data/condicoes_ocupacoes.csv", "insertCondicoesOcupacoes");
        file.insertIntoTableFromFile("data/cores_racas.csv", "insertCoresRacas");
        file.insertIntoTableFromFile("data/cursos_superiores_bases.csv", "insertCursosSuperioresBases");
        file.insertIntoTableFromFile("data/cursos_superiores_gerais.csv", "insertCursosSuperioresGerais");
        file.insertIntoTableFromFile("data/cursos_superiores_principais.csv", "insertCursosSuperioresPrincipais");
        file.insertIntoTableFromFile("data/destinos_lixos.csv", "insertDestinosLixos");
        file.insertIntoTableFromFile("data/dificuldades_permanentes_enxegar_ouvir_caminhar_subir_degrau.csv", "insertDificuldadesPermanentesEnxergarOuvirCaminharSubirDegrau");
        file.insertIntoTableFromFile("data/doutorados_bases.csv", "insertDoutoradosBases");
        file.insertIntoTableFromFile("data/doutorados_gerais.csv", "insertDoutoradosGerais");
        file.insertIntoTableFromFile("data/doutorados_principais.csv", "insertDoutoradosPrincipais");
        file.insertIntoTableFromFile("data/entrevistados.csv", "insertEntrevistados");
        file.insertIntoTableFromFile("data/esgotamentos_sanitarios.csv", "insertEsgotamentosSanitarios");
        file.insertIntoTableFromFile("data/especies.csv", "insertEspecies");
        file.insertIntoTableFromFile("data/especies_unidades_visitadas.csv", "insertEspeciesUnidadesVisitadas");
        file.insertIntoTableFromFile("data/existencias_energias_eletricas.csv", "insertExistenciasEnergiasEletricas");
        file.insertIntoTableFromFile("data/falecimentos_entre_datas.csv", "insertFalecimentosEntreDatas");
        file.insertIntoTableFromFile("data/formas_abastecimentos_aguas.csv", "insertFormasAbastecimentosAguas");
        file.insertIntoTableFromFile("data/formas_declarar_idades.csv", "insertFormasDeclararIdades");
        file.insertIntoTableFromFile("data/geladeiras.csv", "insertGeladeiras");
        file.insertIntoTableFromFile("data/maquinas_lavar_roupa.csv", "insertMaquinasLavarRoupa");
        file.insertIntoTableFromFile("data/marcas_imputacoes.csv", "insertMarcasImputacoes");
        file.insertIntoTableFromFile("data/medidores_relogios_energia.csv", "insertMedidoresRelogiosEnergia");
        file.insertIntoTableFromFile("data/municipios.csv", "insertMunicipios");
        file.insertIntoTableFromFile("data/regioes_geograficas.csv", "insertRegioesGeograficas");
        file.insertIntoTableFromFile("data/unidades_federativas.csv", "insertUnidadesFederativas");

    }
}
