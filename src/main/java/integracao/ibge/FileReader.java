package integracao.ibge;

import integracao.libraries.Config;
import integracao.libraries.ConnectionSGBD;
import integracao.libraries.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileReader {

    public void insertIntoTableFromFile(String fileName, String sqlName) {
        Log.msg("Inserindo " + fileName);
        try {
            ConnectionSGBD conn = new ConnectionSGBD();
            PreparedStatement preparedStatement;
            File arquivoCSV = new File(fileName);
            Log.msg(arquivoCSV.getName());
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCSV), "LATIN1"));
            String linha;
            int q = 1;
            conn.connection("fileReader").setAutoCommit(false);
            while ((linha = in.readLine()) != null) {
                preparedStatement = conn.connection("fileReader").prepareStatement(Config.getProperty(sqlName));
                preprocesColumns(sqlName, preparedStatement, linha);
                preparedStatement.execute();
                q++;
            }
            conn.connection("fileReader").commit();
            Log.msg("Inseridos: " + q);
            in.close();
        } catch (SQLException | FileNotFoundException ex) {
            Log.error(ex);
        } catch (IOException ex) {
            Log.error(ex);
        }
    }

    public void preprocesColumns(String sqlName, PreparedStatement preparedStatement, String linha) {
        try {
            String[] atributos = linha.split(";");
            switch (sqlName) {

                // Inteiro e String
                case "insertAdequacoesMoradias":
                case "insertAtividadesBases":
                case "insertAtividadesCnaeBases":
                case "insertAtividadesCnaePrincipais":
                case "insertAtividadesPrincipais":
                case "insertAutomoveis":
                case "insertCanalizacoesAbastecimentosAguas":
                case "insertCelulares":
                case "insertCondicoesOcupacoes":
                case "insertCoresRacas":
                case "insertCursosSuperioresBases":
                case "insertCursosSuperioresGerais":
                case "insertCursosSuperioresPrincipais":
                case "insertDestinosLixos":
                case "insertDificuldadesPermanentesEnxergarOuvirCaminharSubirDegrau":
                case "insertDoutoradosBases":
                case "insertDoutoradosGerais":
                case "insertDoutoradosPrincipais":
                case "insertEntrevistados":
                case "insertEsgotamentosSanitarios":
                case "insertEspecies":
                case "insertEspeciesUnidadesVisitadas":
                case "insertExistenciasEnergiasEletricas":
                case "insertFalecimentosEntreDatas":
                case "insertFormasAbastecimentosAguas":
                case "insertFormasDeclararIdades":
                case "insertGeladeiras":
                case "insertMaquinasLavarRoupa":
                case "insertMarcasImputacoes":
                case "insertMedidoresRelogiosEnergia":
                case "insertMesorregioes":
                case "insertMestradosBases":
                case "insertMestradosGerais":
                case "insertMestradosPrincipais":
                case "insertMicrocomputadores":
                case "insertMicrocomputadoresAcessoInternet":
                case "insertMicrorregioes":
                case "insertMigracoesDeslocamentosPaisesEstrangeiros":
                case "insertMotocicletas":
                case "insertMunicipios":
                case "insertOcupacoesBases":
                case "insertOcupacoesGerais":
                case "insertOcupacoesPrincipais":
                case "insertOcupacoesSubgrupos":
                case "insertParedesExternas":
                case "insertPessoasMoravamOutrosPaises":
                case "insertQuantidadesBanheiros":
                case "insertQuantidadesComodos":
                case "insertQuantidadesDormitorios":
                case "insertRadios":
                case "insertRegioesGeograficas":
                case "insertRegistrosNascimentos":
                case "insertReligioes":
                case "insertResponsaveisDomicilios":
                case "insertSanitariosBuracosDejecoes":
                case "insertSexos":
                case "insertSituacoesDomicilios":
                case "insertSituacoesSetores":
                case "insertTelefonesFixos":
                case "insertTelevisoes":
                case "insertUnidadesDomesticas":
                case "insertUnidadesFederativas":
                    preparedStatement.setInt(1, Integer.valueOf(atributos[0]));
                    preparedStatement.setString(2, atributos[1]);
                    break;

                //String e String
                case "insertAtividadesCnaeGerais":
                case "insertAtividadesGerais":
                case "insertPonderacoes":
                    preparedStatement.setString(1, atributos[0]);
                    preparedStatement.setString(2, atributos[1]);
                    break;
            }

        } catch (SQLException ex) {
            Log.error(ex);
        }
    }

    public void limpaDados(String tableName) {
        try {
            String sql = "delete from public." + tableName;
            ConnectionSGBD conn = new ConnectionSGBD();
            PreparedStatement preparedStatement;
            preparedStatement = conn.connection("fileReader").prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException ex) {
            Log.error(ex);
        }
    }

}
