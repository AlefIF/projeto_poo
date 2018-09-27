/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Casamento;
import Modelo.Equipe;
import Modelo.Integrante;
import Modelo.Musica;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Guimarães
 */
public class GeraPDF {

    public static void fazRepertorio(Casamento casamentoObj, Equipe equipeLogada) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Repertorio do casamento " + casamentoObj.getNoivos() + " " + casamentoObj.getData() + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("MarriAGE");
        document.addCreator("MarriAGE");
        document.addSubject("MarriAGE - Sistema de contratos de casamentos");
        document.addCreationDate();
        document.addTitle("Repertório - " + equipeLogada.getNome());

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Repertório do casameto de " + casamentoObj.getNoivos() + "</h1>"
                    + "<h3 align=center>" + casamentoObj.getData() + "</h3>"
                    + "<h4 align=center>Equipe " + equipeLogada.getNome() + "</h4>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Nome</strong></th> "
                    + "<th align=center><strong>Artista</strong></th> "
                    + "<th align=center><strong>Tom</strong></th> "
                    + "<th align=center><strong>Quando Tocar</strong></th> "
                    + "</tr> ";
            for (Musica m : casamentoObj.getRepertorio()) {
                frase += "<tr align=center><td>" + m.getNome() + "</td><td>" + m.getArtista() + "</td><td>" + m.getTom() + "</td><td>" + m.getOndeTocar() + "</td></tr>";
            }

            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fazPDFIntegrantes(Equipe equipeLogada) throws FileNotFoundException, DocumentException {
        ArrayList<Integrante> integs = new ArrayList<Integrante>();
        integs = new IntegranteControle().listarTodosIntegrantes(equipeLogada.getCodigo());

        String path = System.getProperty("user.home") + "/Desktop/Integrantes " + equipeLogada.getNome() + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("MarriAGE");
        document.addCreator("MarriAGE");
        document.addSubject("MarriAGE - Sistema de contratos de casamentos");
        document.addCreationDate();
        document.addTitle("Integrantes - " + equipeLogada.getNome());

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Repertório</h1>"
                    + "<h4 align=center>Equipe " + equipeLogada.getNome() + "</h4>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"width:100%; padding-left: 35px; padding-right: 35px;\">\n"
                    + "<tr> "
                    + "<th><strong>Foto</strong></th> "
                    + "<th><strong>Nome</strong></th> "
                    + "<th><strong>Intrumento</strong></th> "
                    + "<th><strong>Idade</strong></th> "
                    + "<th><strong>Contato</strong></th> "
                    + "<th><strong>Tipo</strong></th> "
                    + "</tr> ";
            for (Integrante in : integs) {
                frase += "<tr align=center><td><img style=\"width: 100px; height: 100px;\" src=\"" + in.getFoto() + "\"></td>"
                        + "<td>" + in.getNome() + "</td> <td>" + in.getInstrumentoPrincipal() + "</td> <td>" + in.getIdade() + "</td><td>" + in.getEmail() + " </br> " + in.getFonePrincipal() + "</td>";

                if (in.isFixo() == true) {
                    frase += "<td> Fixo </td>";
                } else {
                    frase += "<td> Terceirizado </td>";
                }

                frase += "</tr>";
            }

            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fazPDFRepertorioDaEquipe(Equipe equipeLogada) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Repertorio " + equipeLogada.getNome() + ".pdf";
        ArrayList<Musica> musicas = new ArrayList<Musica>();
        musicas = new MusicaControle().listarTodosMusica(equipeLogada.getCodigo());
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("MarriAGE");
        document.addCreator("MarriAGE");
        document.addSubject("MarriAGE - Sistema de contratos de casamentos");
        document.addCreationDate();
        document.addTitle("Repertório - " + equipeLogada.getNome());

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Repertório</h1>"
                    + "<h4 align=center>Equipe " + equipeLogada.getNome() + "</h4>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Nome</strong></th> "
                    + "<th align=center><strong>Artista</strong></th> "
                    + "<th align=center><strong>Tom</strong></th> "
                    + "<th align=center><strong>Usado em</strong></th> "
                    + "</tr> ";
            for (Musica m : musicas) {
                frase += "<tr align=center><td>" + m.getNome() + "</td><td>" + m.getArtista() + "</td><td>" + m.getTom() + "</td><td>" + m.getUsadoEm() + "</td></tr>";
            }

            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fazContratoParaContratante(Casamento casamentoObj, Equipe equipeLogada) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Contrato para " + casamentoObj.getNomeContratante() + " do Casamento de " + casamentoObj.getData() + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("MarriAGE");
        document.addCreator("MarriAGE");
        document.addSubject("MarriAGE - Sistema de contratos de casamentos");
        document.addCreationDate();
        document.addTitle("Contrato - " + equipeLogada.getNome());

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Contrato</h1>"
                    + "<h4 align=center>Equipe " + equipeLogada.getNome() + "</h4>"
                    + "</br></br></br>"
                    + "<h4 align=center><b>CONTRATO DE PRESTAÇÃO DE SERVIÇOS MUSICAIS</b> </h4>"
                    + "<br/><br/><br/>"
                    + "<p><u><b>CONTRATANTE:</b></u> " + casamentoObj.getNomeContratante().toUpperCase() + ""
                    + ", portador(a) de RG " + casamentoObj.getRgContratante() + ", inscrito no CPF sob nº " + casamentoObj.getCpfContratante()
                    + ", residente no endereço " + casamentoObj.getEnderecoContratante() + ", detentor do endereço eletrônico " + casamentoObj.getEmailContratante()
                    + " e número(s) telefônico(s) " + casamentoObj.getTelefoneContratante() + "."
                    + "</p>"
                    + "<br/>"
                    + "<p><u><b>CONTRATADO:</b></u> " + equipeLogada.getNomeResponsavel().toUpperCase() + ", portador(a) do RG " + equipeLogada.getRgResponsavel()
                    + ", inscrito(a) no CPF sob nº " + equipeLogada.getCpfResponsavel() + ", residente no endereço " + equipeLogada.getEnderecoResponsavel()
                    + ", detentor do endereço eletrônico " + equipeLogada.getEmail() + ", e número(s) telefônico(s) " + equipeLogada.getTelefoneResponsavel()
                    + ".</p>"
                    + "<br/><br/><br/>"
                    + "<p>Pelo presente instrumento particular de Contrato de Prestação de Serviços, as partes acima qualificadas têm entre si justas e avençadas o seguinte:</p>"
                    + "<br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA PRIMEIRA – DO OBJETO</u></b></h4>"
                    + "<br/><br/>"
                    + "<p> O(A) <b>CONTRATANTE</b>, na busca do serviço musical para a cerimônia do casamento entre " + casamentoObj.getNoivos().toUpperCase()
                    + ", a realizar-se às " + casamentoObj.getHorario() + ", do dia " + Funcoes.DataPorExtenso(casamentoObj.getData())
                    + ", no endereço " + casamentoObj.getEndereco() + ", firma com o <b>CONTRATADO(A)</b>, o(a) qual se obriga a prstar à"
                    + "CONTRATANTE, serviço profissional atinente às habilidades dos músicos no setor musical em diferentes esferas na medida do solicitado."
                    + "<br/><br/>"
                    + "Parágrafo único – <b>O(S) MÚSICO(S)</b> prestará(ão) à CONTRATANTE  no que diz respeito a organização, gestão e oferta de suas habilidades com o(s) INSTRUMENTO(S) pela importância de R$ " + casamentoObj.getTotal()
                    + "."
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA SEGUNDA – DAS CONDIÇÕES DE EXECUÇÃO DOS SERVIÇOS</u></b></h4>"
                    + "<br/><br/>"
                    + "<p> O(A) <b>CONTRATANTE</b> deverá indicar o(a) <b>CONTRATADO(A)</b> – como prestador do(s) serviço(s) – por suas atividades na área musical, bem como sua responsabilidade na organização e realização das mesmas em cerimônias de casamento, à partir do momento em que forem ofertados e disponibilizados os recursos permissíveis e capitais para tal, conforme será firmado na CLÁUSULA TERCEIRA."
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA TERCEIRA – DA REMUNERAÇÃO</u></b></h4>"
                    + "<br/><br/>"
                    + "<p>A <b>CONTRATANTE</b> é responsável por eventuais retenções de impostos e contribuições previstos na legislação tributária e previdenciária e pagará, ao(à) <b>CONTRATADO(A)</b>, a quantia total de R$ " + casamentoObj.getTotal() + " de acordo com a seguinte descrição: \""
                    + casamentoObj.getFormaPagamento() + "\"."
                    + "O pagamento será efetuado pelo(a) CONTRATANTE e deverão ser emitidos, pelo CONTRATADO(A), os respectivos recibos. "
                    + "</p>";
            if (casamentoObj.isPago() == false) {
                frase += "<p>Além do citado, o pagamento deverá ocorrer no dia " + Funcoes.DataPorExtenso(casamentoObj.getDataPagamento()) + ".</p>";
            }
            frase += ""
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA QUARTA – DO REAJUSTE DO PREÇO</u></b></h4>"
                    + "<br/><br/>"
                    + "<p>O preço estipulado na cláusula anterior poderá ser reajustado desde que hajam explicações claras para tal; desde que seja de total consciência e aceitação pelas partes envolvidas; e desde que seja formalizado por meio de uma cláusula de reajuste – a ser assinada por ambas as partes. "
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA QUINTA – DA VIGÊNCIA</u></b></h4>"
                    + "<br/><br/>"
                    + "<p>O presente contrato é válido até a data em que será realizada a cerimônia do casamento, passando a vigorar a partir da data de sua assinatura, podendo ser rescindido por qualquer uma das partes, desde que seja paga a importância de 50% do valor total definido na CLAUSULA TERCEIRA, pelo tempo e trabalho investidos em função do evento tratado nesse contrato."
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA SEXTA – DA RESCISÃO</u></b></h4>"
                    + "<br/><br/>"
                    + "<p>O presente contrato poderá ser rescindido por qualquer uma das partes, mediante notificação a outra por escrito (ou qualquer outra forma, desde que documentada) com prazo mínimo de 60 dias de antecedência, ressalvada a hipótese da parte denunciante indenizar a outra do valor correspondente ao da prestação dos serviços referente ao período.</p>"
                    + "<br/><br/>"
                    + "<p>Parágrafo 1º - O contrato também poderá ser rescindido em caso de violação de quaisquer das cláusulas deste contrato, pela parte prejudicada, mediante denúncia imediata, sem prejuízo de eventual indenização cabível. </p>"
                    + "<p>Parágrafo 2º - Qualquer tolerância das partes quanto ao descumprimento das cláusulas do presente contrato constituirá mera liberalidade, não configurando renúncia ou novação do contrato ou de suas cláusulas que poderão ser exigidos a qualquer tempo.</p>"
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA SÉTIMA – DO REGIME JURÍDICO</u></b></h4>"
                    + "<br/><br/>"
                    + "<p>As partes declaram não haver entre si vínculo empregatício, tendo o (a) <b>CONTRATADO (A)</b> plena autonomia na prestação dos serviços. O (a) <b>CONTRATADO (A)</b> responde exclusivamente por eventual imprudência, negligência, imperícia ou dolo na execução de serviços que venham a causar qualquer dano à <b>CONTRATANTE</b> ou a terceiros, devendo responder regressivamente caso a <b>CONTRATANTE</b> seja responsabilizada judicialmente por tais fatos, desde que haja a denunciação da lide, salvo no caso de conduta da própria <b>CONTRATANTE</b> contrária à orientação dada pelo (a) <b>CONTRATADO (A)</b>."
                    + "</p>"
                    + "<br/><br/>"
                    + "<p>Isso se aplica, de forma mais específica, aos casos de não cumprimento com o tratado firmado para a prestação de serviços. Ausência injustificada e sem remanejo por iniciativa do(a) <b>CONTRATADO (A)</b>, falha na execução em função de fatores advindos de imprudências podem ser enumerados como exemplificações de aplicabilidade do que se firma no primeiro parágrafo dessa cláusula. </p>"
                    + "<br/><br/><br/>"
                    + "<b>LOCAL E DATA</b>: _________________________________________________________"
                    + "<br/><br/>"
                    + "<b>CONTRATANTE</b>: _________________________________________________________"
                    + "<br/><br/>"
                    + "<b>CONTRATADO</b>: _________________________________________________________"
                    + "<br/><br/>"
                    + "<b>TESTEMUNHA 1 (INFORMAR RG)</b>: _________________________________________________________"
                    + "<br/><br/>"
                    + "<b>TESTEMUNHA 2 (INFORMAR RG)</b>: _________________________________________________________"
                    // + casamentoObj.get() +""
                    + "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fazContratoParaTerceirizados(Casamento casamentoObj, Equipe equipeLogada, Integrante integ) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Contrato para MUSICO " + integ.getNome() + " do Casamento de " + casamentoObj.getData() + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("MarriAGE");
        document.addCreator("MarriAGE");
        document.addSubject("MarriAGE - Sistema de contratos de casamentos");
        document.addCreationDate();
        document.addTitle("Contrato - " + equipeLogada.getNome());

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h1 align=center>Contrato</h1>"
                    + "<h4 align=center>Equipe " + equipeLogada.getNome() + "</h4>"
                    + "</br></br></br>"
                    + "<h4 align=center><b>CONTRATO DE TERCEIRIZAÇÃO DE SERVIÇOS MUSICAIS</b> </h4>"
                    + "<br/><br/><br/>"
                    + "<p><u><b>CONTRATANTE:</b></u> " + equipeLogada.getNomeResponsavel().toUpperCase() + ""
                    + ", portador(a) de RG " + equipeLogada.getRgResponsavel() + ", inscrito no CPF sob nº " + equipeLogada.getCpfResponsavel()
                    + ", residente no endereço " + equipeLogada.getEnderecoResponsavel() + ", detentor do endereço eletrônico " + equipeLogada.getEmail()
                    + " e número(s) telefônico(s) " + equipeLogada.getTelefoneResponsavel() + "."
                    + "</p>"
                    + "<br/>"
                    + "<p><u><b>CONTRATADO:</b></u> " + integ.getNome().toUpperCase() + ", portador(a) do RG " + integ.getRg()
                    + ", inscrito(a) no CPF sob nº " + integ.getCpf() + ", residente no endereço " + integ.getEndereco()
                    + ", detentor do endereço eletrônico " + integ.getEmail() + ", e número(s) telefônico(s) " + integ.getFonePrincipal()
                    + ".</p>"
                    + "<br/><br/><br/>"
                    + "<p>Pelo presente instrumento particular de Contrato de Prestação de Serviços, as partes acima qualificadas têm entre si justas e avençadas o seguinte:</p>"
                    + "<br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA PRIMEIRA – DO OBJETO</u></b></h4>"
                    + "<br/><br/>"
                    + "<p> O(A) <b>CONTRATANTE</b>, na busca do serviço musical para a cerimônia do casamento entre " + casamentoObj.getNoivos().toUpperCase()
                    + ", a realizar-se às " + casamentoObj.getHorario() + ", do dia " + Funcoes.DataPorExtenso(casamentoObj.getData())
                    + ", no endereço " + casamentoObj.getEndereco() + ", firma com o <b>CONTRATADO(A)</b>, o(a) qual se obriga a prstar à"
                    + "CONTRATANTE, serviço profissional atinente às habilidades dos músicos no setor musical em diferentes esferas na medida do solicitado."
                    + "<br/><br/>"
                    + "Parágrafo único – <b>O(A) CONTRATADO(A)</b> prestará à <b>CONTRATANTE</b> serviços de gestão e oferta de suas habilidades com o(s) instrumento(s) " + integ.getInstrumentoPrincipal() + " pela importância de R$ " + integ.getSalario() + "."
                    + "."
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA SEGUNDA – DAS CONDIÇÕES DE EXECUÇÃO DOS SERVIÇOS</u></b></h4>"
                    + "<br/><br/>"
                    + "<p> O(A) <b>CONTRATANTE</b> deverá indicar o(a) <b>CONTRATADO(A)</b> – como prestador do(s) serviço(s) – por suas atividades na área musical, bem como sua responsabilidade na organização e realização das mesmas em cerimônias de casamento, à partir do momento em que forem ofertados e disponibilizados os recursos permissíveis e capitais para tal, conforme será firmado na CLÁUSULA TERCEIRA."
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA TERCEIRA – DA REMUNERAÇÃO</u></b></h4>"
                    + "<br/><br/>"
                    + "<p>A <b>CONTRATANTE</b> é responsável por eventuais retenções de impostos e contribuições previstos na legislação tributária e previdenciária e pagará, ao(à) <b>CONTRATADO(A)</b>, a quantia total de R$ " + integ.getSalario() + " de acordo com a seguinte descrição: \""
                    + casamentoObj.getFormaPagamento() + "\"."
                    + "O pagamento será efetuado pelo(a) CONTRATANTE e deverão ser emitidos, pelo mesmo, os respectivos recibos. "
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA QUARTA – DO REAJUSTE DO PREÇO</u></b></h4>"
                    + "<br/><br/>"
                    + "<p>O preço estipulado na cláusula anterior poderá ser reajustado desde que hajam explicações claras para tal; desde que seja de total consciência e aceitação pelas partes envolvidas; e desde que seja formalizado por meio de uma cláusula de reajuste – a ser assinada por ambas as partes. "
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA QUINTA – DA VIGÊNCIA</u></b></h4>"
                    + "<br/><br/>"
                    + "<p>O presente contrato é válido até a data em que será realizada a cerimônia do casamento, passando a vigorar a partir da data de sua assinatura, podendo ser rescindido por qualquer uma das partes, desde que seja paga a importância de 50% do valor total definido na CLAUSULA TERCEIRA, pelo tempo e trabalho investidos em função do evento tratado nesse contrato."
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA SEXTA – DA RESCISÃO</u></b></h4>"
                    + "<br/><br/>"
                    + "<p>O presente contrato poderá ser rescindido por qualquer uma das partes, mediante notificação a outra por escrito (ou qualquer outra forma, desde que documentada) com prazo mínimo de 60 dias de antecedência, ressalvada a hipótese da parte denunciante indenizar a outra do valor correspondente ao da prestação dos serviços referente ao período.</p>"
                    + "<br/><br/>"
                    + "<p>Parágrafo 1º - O contrato também poderá ser rescindido em caso de violação de quaisquer das cláusulas deste contrato, pela parte prejudicada, mediante denúncia imediata, sem prejuízo de eventual indenização cabível. </p>"
                    + "<p>Parágrafo 2º - Qualquer tolerância das partes quanto ao descumprimento das cláusulas do presente contrato constituirá mera liberalidade, não configurando renúncia ou novação do contrato ou de suas cláusulas que poderão ser exigidos a qualquer tempo.</p>"
                    + "</p>"
                    + "<br/><br/><br/>"
                    + "<h4 align=\"center\"><b><u>CLÁUSULA SÉTIMA – DO REGIME JURÍDICO</u></b></h4>"
                    + "<br/><br/>"
                    + "<p>As partes declaram não haver entre si vínculo empregatício, tendo o (a) <b>CONTRATADO (A)</b> plena autonomia na prestação dos serviços. O (a) <b>CONTRATADO (A)</b> responde exclusivamente por eventual imprudência, negligência, imperícia ou dolo na execução de serviços que venham a causar qualquer dano à <b>CONTRATANTE</b> ou a terceiros, devendo responder regressivamente caso a <b>CONTRATANTE</b> seja responsabilizada judicialmente por tais fatos, desde que haja a denunciação da lide, salvo no caso de conduta da própria <b>CONTRATANTE</b> contrária à orientação dada pelo (a) <b>CONTRATADO (A)</b>."
                    + "</p>"
                    + "<br/><br/>"
                    + "<p>Isso se aplica, de forma mais específica, aos casos de não cumprimento com o tratado firmado para a prestação de serviços. Ausência injustificada e sem remanejo por iniciativa do(a) <b>CONTRATADO (A)</b>, falha na execução em função de fatores advindos de imprudências podem ser enumerados como exemplificações de aplicabilidade do que se firma no primeiro parágrafo dessa cláusula. </p>"
                    + "<br/><br/><br/>"
                    + "<b>LOCAL E DATA</b>: _________________________________________________________"
                    + "<br/><br/>"
                    + "<b>CONTRATANTE</b>: _________________________________________________________"
                    + "<br/><br/>"
                    + "<b>CONTRATADO</b>: _________________________________________________________"
                    + "<br/><br/>"
                    + "<b>TESTEMUNHA 1 (INFORMAR RG)</b>: _________________________________________________________"
                    + "<br/><br/>"
                    + "<b>TESTEMUNHA 2 (INFORMAR RG)</b>: _________________________________________________________"
                    // + casamentoObj.get() +""
                    + "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reciboContratante(Casamento casObj, Equipe equipeLogada) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Recibo para " + casObj.getNomeContratante() + " do Casamento de " + casObj.getData() + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("MarriAGE");
        document.addCreator("MarriAGE");
        document.addSubject("MarriAGE - Sistema de contratos de casamentos");
        document.addCreationDate();
        document.addTitle("Recibo - " + equipeLogada.getNome());

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h2 align=\"center\">Recibo de pagamento</h2>"
                    + "<p>Eu, " + equipeLogada.getNomeResponsavel() + ", responsável pela equipe de música " + equipeLogada.getNome() + ", declaro que recebi do Sr.(a) " + casObj.getNomeContratante() + ",</p>"
                    + "<p>contratante dos serviços musicais, da marca citada anteriormente, portador do documento de identificação " + casObj.getRgContratante() + ", residente do endereço: </p>"
                    + "<p>" + casObj.getEnderecoContratante() + ", o valor de R$:" + casObj.getTotal() + ".</p>"
                    + "<p>Referente aos serviços ou vendas: _______________________________________________________________________________</p>"
                    + "<p>Local e data: _______________________________________________________________________________ </p>"
                    + "<p>Assinatura: _______________________________________________________________________________ </p>"
                    + "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reciboMusico(Casamento casObj, Integrante integ, Equipe equipeLogada) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Recibo para " + integ.getNome() + " do Casamento de " + casObj.getData() + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("MarriAGE");
        document.addCreator("MarriAGE");
        document.addSubject("MarriAGE - Sistema de contratos de casamentos");
        document.addCreationDate();
        document.addTitle("Recibo - " + equipeLogada.getNome());

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<h2 align=\"center\">Recibo de pagamento</h2>"
                    + "<p>Eu, " + integ.getNome() + ",músico, declaro que recebi do Sr.(a) " + equipeLogada.getNomeResponsavel() + ",</p>"
                    + "<p>, responsável pela equipe musical " + equipeLogada.getNome() + ", portador do documento de identificação " + equipeLogada.getRgResponsavel() + ", residente do endereço: </p>"
                    + "<p>" + equipeLogada.getEnderecoResponsavel() + ", o valor de R$:" + integ.getSalario() + ".</p>"
                    + "<p>Referente aos serviços ou vendas: _______________________________________________________________________________</p>"
                    + "<p>Local e data: _______________________________________________________________________________ </p>"
                    + "<p>Assinatura: _______________________________________________________________________________ </p>"
                    + "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void fazPDFSenha(Equipe eq) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/ Bem-vindo ao MarriAGE, " + eq.getNomeResponsavel() + ".pdf";
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("MarriAGE");
        document.addCreator("MarriAGE");
        document.addSubject("MarriAGE - Sistema de contratos de casamentos");
        document.addCreationDate();
        document.addTitle("Boas Vindas");

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> <meta charset=\"utf-8\"> </head>"
                    + "<body>"
                    + "<p>Bem vindo," + eq.getNomeResponsavel() + "!</p>"
                    + "<p>Login:" + eq.getLogin() + "</p>"
                    + "<p>Senha: " + eq.getSenha() + "</p>"
                    + "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fazPDFAgendaDeCasamento(Equipe equipeLogada) throws FileNotFoundException, DocumentException {
        String path = System.getProperty("user.home") + "/Desktop/Agenda " + equipeLogada.getNome() + ".pdf";
        ArrayList<Casamento> casamentos = new ArrayList<Casamento>();
        casamentos = new CasamentoControle().listaPorDia(equipeLogada.getCodigo());
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.addAuthor("MarriAGE");
        document.addCreator("MarriAGE");
        document.addSubject("MarriAGE - Sistema de contratos de casamentos");
        document.addCreationDate();
        document.addTitle("Agenda - " + equipeLogada.getNome());

        HTMLWorker htmlWorker = new HTMLWorker(document);

        String frase;
        try {
            frase = "<html>"
                    + "<head> "
                    + " <meta charset=\"utf-8\"> "
                    + "</head>"
                    + "<body >"
                    + "<h1 align=center>Agenda</h1>"
                    + "<h4 align=center>Equipe " + equipeLogada.getNome() + "</h4>"
                    + "</br></br></br>"
                    + "<table BORDER RULES=rows border=0 style=\"  width:100%; \">\n"
                    + "<tr> "
                    + "<th align=center><strong>Dias restantes</strong></th> "
                    + "<th align=center><strong>Noivos</strong></th> "
                    + "<th align=center><strong>Preço</strong></th> "
                    + "<th align=center><strong>Endereço</strong></th> "
                    + "</tr> ";
            for (Casamento c : casamentos) {
                frase += "<tr align=center><td>" + c.getDiasFaltando() + "</td><td>" + c.getNoivos() + "</td><td>" + c.getTotal() + "</td><td>" + c.getEndereco() + "</td></tr>";
            }

            frase += "</table>";
            frase += "</body></html>";
            htmlWorker.parse(new StringReader(frase));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
