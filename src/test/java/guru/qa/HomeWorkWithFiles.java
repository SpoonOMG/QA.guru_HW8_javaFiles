package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.init.Root;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeWorkWithFiles {
    ClassLoader cl = HomeWorkWithFiles.class.getClassLoader();

    @Test
    void pdfTest() throws IOException {
        try (InputStream pdfFile = cl.getResourceAsStream("agreement.pdf")){
            PDF pdfContent = new PDF(pdfFile);
            assertThat(pdfContent.title).contains("Договор купли-продажи транспортного средства");
    }
    }

    @Test
    void xlsTest() throws Exception {
        try (InputStream xlsFile = cl.getResourceAsStream("Таблица.xls")){
        XLS xlsContent = new XLS(xlsFile);
        assertThat(xlsContent.excel.getSheetAt(0).getRow(1).getCell(0).getStringCellValue()).contains("Приседания");
    }
    }
    @Test
    void csvTest() throws IOException, CsvException {
        try(
        InputStream csvFile = cl.getResourceAsStream("annual-enterprise-survey-2021-financial-year-provisional-csv.csv");
        CSVReader csvContent = new CSVReader(new InputStreamReader(csvFile))
        ){
        List<String[]> content = csvContent.readAll();
                    assertThat(content.get(5)[1]).contains("Level 1");
        }
    }

    @Test
    void jsonTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File initJsonFile = new File("src/test/resources/init.json");
        Root init = objectMapper.readValue(initJsonFile,Root.class);
        assertThat(init.meta.channel).contains("ufo");
        assertThat(init.data.scenario.id).contains("sc_6bd8843469e7c68");
        assertThat(init.data.clientContext.employee.department.code).contains("099/1039");
        assertThat(init.data.verifyData.values.get(0).id).contains("login");
        assertThat(init.data.verifyData.values.get(0).value).contains("gpbu9650");
    }

    @Test
    void extractZipFile() throws IOException, CsvException {
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("FileArchive.zip"));
        ZipEntry entry;
        while((entry = is.getNextEntry()) != null) {
            if (entry.getName().contains("agreement.pdf")){
                PDF pdfContent = new PDF(is);
                assertThat(pdfContent.title).contains("Договор купли-продажи транспортного средства");
            }else if (entry.getName().contains("annual")){
                CSVReader csvContent = new CSVReader (new InputStreamReader(is));
                List<String[]> content = csvContent.readAll();
                assertThat(content.get(5)[1]).contains("Level 1");
            } else if (entry.getName().contains("xlsFile")) {
                XLS xlsContent = new XLS(is);
                assertThat(xlsContent.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue()).contains("ПЛАТЕЖЕЙ ПО ИПОТЕКЕ");
            }
        }

    }

}
