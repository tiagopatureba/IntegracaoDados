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
                case "insertUnidadesFederativas":
                case "insertAtividadesBases":
                case "insertMunicipios":
                case "insertRegioesGeograficas":
                    preparedStatement.setInt(1, Integer.valueOf(atributos[0]));
                    preparedStatement.setString(2, atributos[1]);
                    break;

                //case "insertMunicipio":
                //    preparedStatement.setInt(1, Integer.valueOf(atributos[0]));
                //    preparedStatement.setInt(2, Integer.valueOf(atributos[1]));
                //    preparedStatement.setString(3, atributos[2]);
                //    break;
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
