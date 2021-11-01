import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;
import java.util.LinkedList;


public class Tesis {

    static File file;
    static boolean phased = false;
    static int jumlahteam = 0;
    static int jumlahslot = 0;
    static LinkedList<String[]> CA1 = new LinkedList<>();
    static LinkedList<String[]> CA2 = new LinkedList<>();
    static LinkedList<String[]> CA3 = new LinkedList<>();
    static LinkedList<String[]> CA4 = new LinkedList<>();
    static LinkedList<String[]> GA1 = new LinkedList<>();
    static LinkedList<String[]> BR1 = new LinkedList<>();
    static LinkedList<String[]> BR2 = new LinkedList<>();
    static LinkedList<String[]> FA2 = new LinkedList<>();
    static LinkedList<String[]> SE1 = new LinkedList<>();
    static int ca1hard = 0; static int ca1soft = 0;
    static int ca2hard = 0; static int ca2soft = 0;
    static int ca3hard = 0; static int ca3soft = 0;
    static int ca4hard = 0; static int ca4soft = 0;
    static int ga1hard = 0; static int ga1soft = 0;
    static int br1hard = 0; static int br1soft = 0;
    static int br2hard = 0; static int br2soft = 0;
    static int fa2hard = 0; static int fa2soft = 0;
    static int se1hard = 0; static int se1soft = 0;
    static CCA1[] CA1Hard;
    static CCA1[] CA1Soft;
    static CCA2[] CA2Hard;
    static CCA2[] CA2Soft;
    static CCA3[] CA3Hard;
    static CCA3[] CA3Soft;
    static CCA4[] CA4Hard;
    static CCA4[] CA4Soft;
    static CGA1[] GA1Hard;
    static CGA1[] GA1Soft;
    static CBR1[] BR1Hard;
    static CBR1[] BR1Soft;
    static CBR2[] BR2Hard;
    static CBR2[] BR2Soft;
    static CFA2[] FA2Hard;
    static CFA2[] FA2Soft;
    static CSE1[] SE1Hard;
    static CSE1[] SE1Soft;
    static LinkedList<int[]>[] solutions;

    public static void main(String arg[]) throws ParserConfigurationException, SAXException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int readSol = Integer.parseInt(br.readLine());
        int sol = -1;
        if(readSol!=0)
            sol = Integer.parseInt(br.readLine());
        String ins = br.readLine();
        int tulis = Integer.parseInt(br.readLine());
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {

            public boolean bfname = false;
            boolean phase = false;

            public void startElement(String uri, String localName,String qName,
                                     Attributes attributes) throws SAXException {
                if(qName.equalsIgnoreCase("gameMode"))
                {
                    phase = true;
                }
                if(qName.equalsIgnoreCase("team"))
                {
                    jumlahteam++;
                }
                if(qName.equalsIgnoreCase("slot"))
                {
                    jumlahslot++;
                }
                if (qName.equalsIgnoreCase("FIRSTNAME")) {
                    bfname = true;
                }
                if(qName.equalsIgnoreCase("CA1"))
                {
                    String [] CA1temp = new String [7];
                    CA1temp[0] = attributes.getValue("max");
                    CA1temp[1] = attributes.getValue("min");
                    CA1temp[2] = attributes.getValue("mode");
                    CA1temp[3] = attributes.getValue("penalty");
                    CA1temp[4] = attributes.getValue("slots");
                    CA1temp[5] = attributes.getValue("teams");
                    CA1temp[6] = attributes.getValue("type");
                    if(attributes.getValue("type").equalsIgnoreCase("HARD"))
                        ca1hard += 1;
                    else
                        ca1soft += 1;
                    CA1.add(CA1temp);
                }
                if(qName.equalsIgnoreCase("CA2"))
                {
                    String [] CA2temp = new String [8];
                    CA2temp[0] = attributes.getValue("max");
                    CA2temp[1] = attributes.getValue("min");
                    CA2temp[2] = attributes.getValue("mode1");
                    CA2temp[3] = attributes.getValue("penalty");
                    CA2temp[4] = attributes.getValue("slots");
                    CA2temp[5] = attributes.getValue("teams1");
                    CA2temp[6] = attributes.getValue("teams2");
                    CA2temp[7] = attributes.getValue("type");
                    if(attributes.getValue("type").equalsIgnoreCase("HARD"))
                        ca2hard += 1;
                    else
                        ca2soft += 1;
                    CA2.add(CA2temp);
                }
                if(qName.equalsIgnoreCase("CA3"))
                {
                    String [] CA3temp = new String [8];
                    CA3temp[0] = attributes.getValue("intp");
                    CA3temp[1] = attributes.getValue("max");
                    CA3temp[2] = attributes.getValue("min");
                    CA3temp[3] = attributes.getValue("mode1");
                    CA3temp[4] = attributes.getValue("penalty");
                    CA3temp[5] = attributes.getValue("teams1");
                    CA3temp[6] = attributes.getValue("teams2");
                    CA3temp[7] = attributes.getValue("type");
                    if(attributes.getValue("type").equalsIgnoreCase("HARD"))
                        ca3hard += 1;
                    else
                        ca3soft += 1;
                    CA3.add(CA3temp);
                }
                if(qName.equalsIgnoreCase("CA4"))
                {
                    String [] CA4temp = new String [9];
                    CA4temp[0] = attributes.getValue("max");
                    CA4temp[1] = attributes.getValue("min");
                    CA4temp[2] = attributes.getValue("mode1");
                    CA4temp[3] = attributes.getValue("mode2");
                    CA4temp[4] = attributes.getValue("penalty");
                    CA4temp[5] = attributes.getValue("slots");
                    CA4temp[6] = attributes.getValue("teams1");
                    CA4temp[7] = attributes.getValue("teams2");
                    CA4temp[8] = attributes.getValue("type");
                    if(attributes.getValue("type").equalsIgnoreCase("HARD"))
                        ca4hard += 1;
                    else
                        ca4soft += 1;
                    CA4.add(CA4temp);
                }
                if(qName.equalsIgnoreCase("GA1"))
                {
                    String [] GA1temp = new String [6];
                    GA1temp[0] = attributes.getValue("max");
                    GA1temp[1] = attributes.getValue("meetings");
                    GA1temp[2] = attributes.getValue("min");
                    GA1temp[3] = attributes.getValue("penalty");
                    GA1temp[4] = attributes.getValue("slots");
                    GA1temp[5] = attributes.getValue("type");
                    if(attributes.getValue("type").equalsIgnoreCase("HARD"))
                        ga1hard += 1;
                    else
                        ga1soft += 1;
                    GA1.add(GA1temp);
                }
                if(qName.equalsIgnoreCase("BR1"))
                {
                    String [] BR1temp = new String [6];
                    BR1temp[0] = attributes.getValue("intp");
                    BR1temp[1] = attributes.getValue("mode2");
                    BR1temp[2] = attributes.getValue("penalty");
                    BR1temp[3] = attributes.getValue("slots");
                    BR1temp[4] = attributes.getValue("teams");
                    BR1temp[5] = attributes.getValue("type");
                    if(attributes.getValue("type").equalsIgnoreCase("HARD"))
                        br1hard += 1;
                    else
                        br1soft += 1;
                    BR1.add(BR1temp);
                }
                if(qName.equalsIgnoreCase("BR2"))
                {
                    String [] BR2temp = new String [5];
                    BR2temp[0] = attributes.getValue("intp");
                    BR2temp[1] = attributes.getValue("penalty");
                    BR2temp[2] = attributes.getValue("slots");
                    BR2temp[3] = attributes.getValue("teams");
                    BR2temp[4] = attributes.getValue("type");
                    if(attributes.getValue("type").equalsIgnoreCase("HARD"))
                        br2hard += 1;
                    else
                        br2soft += 1;
                    BR2.add(BR2temp);
                }
                if(qName.equalsIgnoreCase("FA2"))
                {
                    String [] FA2temp = new String [5];
                    FA2temp[0] = attributes.getValue("intp");
                    FA2temp[1] = attributes.getValue("penalty");
                    FA2temp[2] = attributes.getValue("slots");
                    FA2temp[3] = attributes.getValue("teams");
                    FA2temp[4] = attributes.getValue("type");
                    if(attributes.getValue("type").equalsIgnoreCase("HARD"))
                        fa2hard += 1;
                    else
                        fa2soft += 1;
                    FA2.add(FA2temp);
                }
                if(qName.equalsIgnoreCase("SE1"))
                {
                    String [] SE1temp = new String [4];
                    SE1temp[0] = attributes.getValue("min");
                    SE1temp[1] = attributes.getValue("penalty");
                    SE1temp[2] = attributes.getValue("teams");
                    SE1temp[3] = attributes.getValue("type");
                    if(attributes.getValue("type").equalsIgnoreCase("HARD"))
                        se1hard += 1;
                    else
                        se1soft += 1;
                    SE1.add(SE1temp);
                }
            }

            public void characters(char ch[], int start, int length) throws SAXException {
                if(phase)
                {
                    if(new String(ch, start, length).equalsIgnoreCase("P"))
                        phased = true;
                    phase = false;
                }
            }
        };
        file = new File("e:\\late\\ITC2021_Late_"+ins+".xml");
        saxParser.parse(file, handler);

//        for(int i=0; i<CA1.size(); i++)
//        {
//            for(int j=0; j<CA1.get(i).length; j++)
//            {
//                System.out.print(CA1.get(i)[j]+" ");
//            }
//            System.out.println();
//        }

        ////////////////////////////////////MEMBUAT OBJEK CONSTRAINT CA1////////////////////////////////////////////////

        if(ca1hard>0 || ca1soft>0) {
            String [][] slot = new String[CA1.size()][];
            for(int i=0; i<CA1.size(); i++)
                slot[i] = CA1.get(i)[4].split(";");
            LinkedList<Integer>[] slot2 = new LinkedList[slot.length];
            for(int i=0; i<slot.length; i++) {
                slot2[i] = new LinkedList<>();
                for (int j = 0; j < slot[i].length; j++)
                    slot2[i].add(Integer.parseInt(slot[i][j]));
            }
            String [][] team = new String[CA1.size()][];
            for(int i=0; i<CA1.size(); i++)
                team[i] = CA1.get(i)[5].split(";");
            LinkedList<Integer>[] team2 = new LinkedList[team.length];
            for(int i=0 ; i<team.length; i++)
            {
                team2[i] = new LinkedList<>();
                for(int j=0; j<team[i].length;j++)
                    team2[i].add(Integer.parseInt(team[i][j]));
            }
            CA1Hard = new CCA1[ca1hard];
            CA1Soft = new CCA1[ca1soft];
            int h =0;
            int s =0;
            for (int i = 0; i < CA1.size(); i++) {
                if(CA1.get(i)[6].equalsIgnoreCase("HARD")) {
                    CA1Hard[h] = new CCA1(Integer.parseInt(CA1.get(i)[0]), Integer.parseInt(CA1.get(i)[1]),
                            CA1.get(i)[2], Integer.parseInt(CA1.get(i)[3]), slot2[i], team2[i]);
                    h++;
                }
                else {
                    CA1Soft[s] = new CCA1(Integer.parseInt(CA1.get(i)[0]), Integer.parseInt(CA1.get(i)[1]),
                            CA1.get(i)[2], Integer.parseInt(CA1.get(i)[3]), slot2[i], team2[i]);
                    s++;
                }
            }
        }

        ///////////////////////////////////////MEMBUAT OBJEK CONTRAINT CA2//////////////////////////////////////////////

        if(ca2hard>0 || ca2soft>0)
        {
            String [][] slot = new String[CA2.size()][];
            for(int i=0; i<CA2.size();i++)
                slot[i] = CA2.get(i)[4].split(";");
            LinkedList<Integer>[] slota = new LinkedList[slot.length];
            for(int i=0; i<slota.length; i++)
            {
                slota[i] = new LinkedList<>();
                for(int j=0; j<slot[i].length; j++)
                    slota[i].add(Integer.parseInt(slot[i][j]));
            }
            String [][] team1 = new String[CA2.size()][];
            for(int i=0; i<CA2.size();i++)
                team1[i] = CA2.get(i)[5].split(";");
            LinkedList<Integer>[] team1a = new LinkedList[team1.length];
            for(int i=0; i<team1a.length; i++)
            {
                team1a[i] = new LinkedList<>();
                for(int j=0; j<team1[i].length; j++)
                    team1a[i].add(Integer.parseInt(team1[i][j]));
            }
            String [][] team2 = new String[CA2.size()][];
            for(int i=0; i<CA2.size();i++)
                team2[i] = CA2.get(i)[6].split(";");
            LinkedList<Integer>[] team2a = new LinkedList[team2.length];
            for(int i=0; i<team2a.length; i++)
            {
                team2a[i] = new LinkedList<>();
                for(int j=0; j<team2[i].length; j++)
                    team2a[i].add(Integer.parseInt(team2[i][j]));
            }
            CA2Hard = new CCA2[ca2hard];
            CA2Soft = new CCA2[ca2soft];
            int h = 0;
            int s = 0;
            for(int i=0; i<CA2.size(); i++)
            {
                if(CA2.get(i)[7].equalsIgnoreCase("HARD")) {
                    CA2Hard[h] = new CCA2(Integer.parseInt(CA2.get(i)[0]), Integer.parseInt(CA2.get(i)[1]),
                            CA2.get(i)[2], Integer.parseInt(CA2.get(i)[3]), slota[i], team1a[i], team2a[i]);
                    h++;
                }
                else {
                    CA2Soft[s] = new CCA2(Integer.parseInt(CA2.get(i)[0]), Integer.parseInt(CA2.get(i)[1]),
                            CA2.get(i)[2], Integer.parseInt(CA2.get(i)[3]), slota[i], team1a[i], team2a[i]);
                    s++;
                }
            }
        }

        ////////////////////////////////////MEMBUAT OBJEK CONTRAINT CA3/////////////////////////////////////////////////

        if(ca3hard>0 || ca3soft>0)
        {
            String [][] team1 = new String[CA3.size()][];
            for(int i=0; i<CA3.size();i++)
                team1[i] = CA3.get(i)[5].split(";");
            LinkedList<Integer>[] team1a = new LinkedList[team1.length];
            for(int i=0; i<team1a.length; i++)
            {
                team1a[i] = new LinkedList<>();
                for(int j=0; j<team1[i].length; j++)
                    team1a[i].add(Integer.parseInt(team1[i][j]));
            }
            String [][] team2 = new String[CA3.size()][];
            for(int i=0; i<CA3.size();i++)
                team2[i] = CA3.get(i)[6].split(";");
            LinkedList<Integer>[] team2a = new LinkedList[team2.length];
            for(int i=0; i<team2a.length; i++)
            {
                team2a[i] = new LinkedList<>();
                for(int j=0; j<team2[i].length; j++)
                    team2a[i].add(Integer.parseInt(team2[i][j]));
            }
            CA3Hard = new CCA3[ca3hard];
            CA3Soft = new CCA3[ca3soft];
            int h = 0;
            int s = 0;
            for(int i=0; i<CA3.size(); i++)
            {
                if(CA3.get(i)[7].equalsIgnoreCase("HARD")) {
                    CA3Hard[h] = new CCA3(Integer.parseInt(CA3.get(i)[0]), Integer.parseInt(CA3.get(i)[1]),
                            Integer.parseInt(CA3.get(i)[2]), CA3.get(i)[3], Integer.parseInt(CA3.get(i)[4]),
                            team1a[i], team2a[i]);
                    h++;
                }
                else {
                    CA3Soft[s] = new CCA3(Integer.parseInt(CA3.get(i)[0]), Integer.parseInt(CA3.get(i)[1]),
                            Integer.parseInt(CA3.get(i)[2]), CA3.get(i)[3], Integer.parseInt(CA3.get(i)[4]),
                            team1a[i], team2a[i]);
                    s++;
                }
            }
        }

        /////////////////////////////////////////MEMBUAT OBJEK CONSTRAINT CA4///////////////////////////////////////////

        if(ca4hard>0 || ca4soft>0)
        {
            String [][] slot = new String[CA4.size()][];
            for(int i=0; i<CA4.size();i++)
                slot[i] = CA4.get(i)[5].split(";");
            LinkedList<Integer>[] slota = new LinkedList[slot.length];
            for(int i=0; i<slota.length; i++)
            {
                slota[i] = new LinkedList<>();
                for(int j=0; j<slot[i].length; j++)
                    slota[i].add(Integer.parseInt(slot[i][j]));
            }
            String [][] team1 = new String[CA4.size()][];
            for(int i=0; i<CA4.size();i++)
                team1[i] = CA4.get(i)[6].split(";");
            LinkedList<Integer>[] team1a = new LinkedList[team1.length];
            for(int i=0; i<team1a.length; i++)
            {
                team1a[i] = new LinkedList<>();
                for(int j=0; j<team1[i].length; j++)
                    team1a[i].add(Integer.parseInt(team1[i][j]));
            }
            String [][] team2 = new String[CA4.size()][];
            for(int i=0; i<CA4.size();i++)
                team2[i] = CA4.get(i)[7].split(";");
            LinkedList<Integer>[] team2a = new LinkedList[team2.length];
            for(int i=0; i<team2a.length; i++)
            {
                team2a[i] = new LinkedList<>();
                for(int j=0; j<team2[i].length; j++)
                    team2a[i].add(Integer.parseInt(team2[i][j]));
            }
            CA4Hard = new CCA4[ca4hard];
            CA4Soft = new CCA4[ca4soft];
            int h = 0;
            int s = 0;
            for(int i=0; i<CA4.size(); i++)
            {
                if(CA4.get(i)[8].equalsIgnoreCase("HARD")) {
                    CA4Hard[h] = new CCA4(Integer.parseInt(CA4.get(i)[0]), Integer.parseInt(CA4.get(i)[1]),
                            CA4.get(i)[2], CA4.get(i)[3], Integer.parseInt(CA4.get(i)[4]), slota[i],
                            team1a[i], team2a[i]);
                    h++;
                }
                else {
                    CA4Soft[s] = new CCA4(Integer.parseInt(CA4.get(i)[0]), Integer.parseInt(CA4.get(i)[1]),
                            CA4.get(i)[2], CA4.get(i)[3], Integer.parseInt(CA4.get(i)[4]), slota[i],
                            team1a[i], team2a[i]);
                    s++;
                }
            }
        }

        ////////////////////////////////////////////////MEMBUAT OBJEK CONTRAINT GA1/////////////////////////////////////

        if(ga1hard>0 || ga1soft>0)
        {
            String [][] meet = new String[GA1.size()][];
            for(int i=0; i<GA1.size();i++) {
                    meet[i] = GA1.get(i)[1].split(";");
            }
            LinkedList<Integer[]>[] meets = new LinkedList[GA1.size()];
            for(int i=0; i<GA1.size(); i++)
            {
                meets[i] = new LinkedList<>();
                for(int j=0; j<meet[i].length; j++)
                {
                    meets[i].add(new Integer[2]);
                    if(meet[i][j].length()==3) {
                        meets[i].get(j)[0] = Integer.parseInt(String.valueOf(meet[i][j].charAt(0)));
                        meets[i].get(j)[1] = Integer.parseInt(String.valueOf(meet[i][j].charAt(2)));
                    }
                    if(meet[i][j].length()==5)
                    {
                        meets[i].get(j)[0] = Integer.parseInt(meet[i][j].substring(0,2));
                        meets[i].get(j)[1] = Integer.parseInt(meet[i][j].substring(3));
                    }
                    if(meet[i][j].length()==4)
                    {
                        if(meet[i][j].indexOf(",")==1)
                        {
                            meets[i].get(j)[0] = Integer.parseInt(String.valueOf(meet[i][j].charAt(0)));
                            meets[i].get(j)[1] = Integer.parseInt(meet[i][j].substring(2));
                        }
                        else
                        {
                            meets[i].get(j)[0] = Integer.parseInt(meet[i][j].substring(0,2));
                            meets[i].get(j)[1] = Integer.parseInt(String.valueOf(meet[i][j].charAt(3)));
                        }

                    }
                }
            }
            String [][] slot = new String[GA1.size()][];
            for(int i=0; i<GA1.size();i++)
                slot[i] = GA1.get(i)[4].split(";");
            LinkedList<Integer>[] slota = new LinkedList[slot.length];
            for(int i=0; i<slota.length; i++)
            {
                slota[i] = new LinkedList<>();
                for(int j=0; j<slot[i].length; j++)
                    slota[i].add(Integer.parseInt(slot[i][j]));
            }
            GA1Hard = new CGA1[ga1hard];
            GA1Soft = new CGA1[ga1soft];
            int h = 0;
            int s = 0;
            for(int i=0; i<GA1.size(); i++)
            {
                if(GA1.get(i)[5].equalsIgnoreCase("HARD")) {
                    GA1Hard[h] = new CGA1(Integer.parseInt(GA1.get(i)[0]), meets[i], Integer.parseInt(GA1.get(i)[2]),
                            Integer.parseInt(GA1.get(i)[3]), slota[i]);
                    h++;
                }
                else {
                    GA1Soft[s] = new CGA1(Integer.parseInt(GA1.get(i)[0]), meets[i], Integer.parseInt(GA1.get(i)[2]),
                            Integer.parseInt(GA1.get(i)[3]), slota[i]);
                    s++;
                }
            }
        }

        ////////////////////////////////////////////////MEMBUAT OBJEK CONTRAINT BR1/////////////////////////////////////

        if(br1hard>0 || br1soft>0)
        {
            String [][] slot = new String[BR1.size()][];
            for(int i=0; i<BR1.size();i++)
                slot[i] = BR1.get(i)[3].split(";");
            LinkedList<Integer>[] slota = new LinkedList[slot.length];
            for(int i=0; i<slota.length; i++)
            {
                slota[i] = new LinkedList<>();
                for(int j=0; j<slot[i].length; j++)
                    slota[i].add(Integer.parseInt(slot[i][j]));
            }
            String [][] team1 = new String[BR1.size()][];
            for(int i=0; i<BR1.size();i++)
                team1[i] = BR1.get(i)[4].split(";");
            LinkedList<Integer>[] team1a = new LinkedList[team1.length];
            for(int i=0; i<team1a.length; i++)
            {
                team1a[i] = new LinkedList<>();
                for(int j=0; j<team1[i].length; j++)
                    team1a[i].add(Integer.parseInt(team1[i][j]));
            }
            BR1Hard = new CBR1[br1hard];
            BR1Soft = new CBR1[br1soft];
            int h = 0;
            int s = 0;
            for(int i=0; i<BR1.size(); i++)
            {
                if(BR1.get(i)[5].equalsIgnoreCase("HARD")) {
                    BR1Hard[h] = new CBR1(Integer.parseInt(BR1.get(i)[0]), BR1.get(i)[1], Integer.parseInt(BR1.get(i)[2]),
                            slota[i], team1a[i]);
                    h++;
                }
                else {
                    BR1Soft[s] = new CBR1(Integer.parseInt(BR1.get(i)[0]), BR1.get(i)[1], Integer.parseInt(BR1.get(i)[2]),
                            slota[i], team1a[i]);
                    s++;
                }
            }
        }

        ///////////////////////////////////////////////////MEMBUAT OBJEK CONTRAINT BR2//////////////////////////////////

        if(br2hard>0 || br2soft>0)
        {
            String [][] slot = new String[BR2.size()][];
            for(int i=0; i<BR2.size();i++)
                slot[i] = BR2.get(i)[2].split(";");
            LinkedList<Integer>[] slota = new LinkedList[slot.length];
            for(int i=0; i<slota.length; i++)
            {
                slota[i] = new LinkedList<>();
                for(int j=0; j<slot[i].length; j++)
                    slota[i].add(Integer.parseInt(slot[i][j]));
            }
            String [][] team1 = new String[BR2.size()][];
            for(int i=0; i<BR2.size();i++)
                team1[i] = BR2.get(i)[3].split(";");
            LinkedList<Integer>[] team1a = new LinkedList[team1.length];
            for(int i=0; i<team1a.length; i++)
            {
                team1a[i] = new LinkedList<>();
                for(int j=0; j<team1[i].length; j++)
                    team1a[i].add(Integer.parseInt(team1[i][j]));
            }
            BR2Hard = new CBR2[br2hard];
            BR2Soft = new CBR2[br2soft];
            int h = 0;
            int s = 0;
            for(int i=0; i<BR2.size(); i++)
            {
                if(BR2.get(i)[4].equalsIgnoreCase("HARD")) {
                    BR2Hard[h] = new CBR2(Integer.parseInt(BR2.get(i)[0]), Integer.parseInt(BR2.get(i)[1]),
                            slota[i], team1a[i]);
                    h++;
                }
                else {
                    BR2Soft[s] = new CBR2(Integer.parseInt(BR2.get(i)[0]), Integer.parseInt(BR2.get(i)[1]),
                            slota[i], team1a[i]);
                    s++;
                }
            }
        }

        ////////////////////////////////////////////////MEMBUAT OBJEK CONTRAINT FA2/////////////////////////////////////

        if(fa2hard>0 || fa2soft>0)
        {
            String [][] slot = new String[FA2.size()][];
            for(int i=0; i<FA2.size();i++)
                slot[i] = FA2.get(i)[2].split(";");
            LinkedList<Integer>[] slota = new LinkedList[slot.length];
            for(int i=0; i<slota.length; i++)
            {
                slota[i] = new LinkedList<>();
                for(int j=0; j<slot[i].length; j++)
                    slota[i].add(Integer.parseInt(slot[i][j]));
            }
            String [][] team1 = new String[FA2.size()][];
            for(int i=0; i<FA2.size();i++)
                team1[i] = FA2.get(i)[3].split(";");
            LinkedList<Integer>[] team1a = new LinkedList[team1.length];
            for(int i=0; i<team1a.length; i++)
            {
                team1a[i] = new LinkedList<>();
                for(int j=0; j<team1[i].length; j++)
                    team1a[i].add(Integer.parseInt(team1[i][j]));
            }
            FA2Hard = new CFA2[fa2hard];
            FA2Soft = new CFA2[fa2soft];
            int h = 0;
            int s = 0;
            for(int i=0; i<FA2.size(); i++)
            {
                if(FA2.get(i)[4].equalsIgnoreCase("HARD")) {
                    FA2Hard[h] = new CFA2(Integer.parseInt(FA2.get(i)[0]), Integer.parseInt(FA2.get(i)[1]),
                            slota[i], team1a[i]);
                    h++;
                }
                else {
                    FA2Soft[s] = new CFA2(Integer.parseInt(FA2.get(i)[0]), Integer.parseInt(FA2.get(i)[1]),
                            slota[i], team1a[i]);
                    s++;
                }
            }
        }

        //////////////////////////////////////////////MEMBUAT OBJEK CONSTRAINT SE1//////////////////////////////////////

        if(se1hard>0 || se1soft>0)
        {
            String [][] team1 = new String[SE1.size()][];
            for(int i=0; i<SE1.size();i++)
                team1[i] = SE1.get(i)[2].split(";");
            LinkedList<Integer>[] team1a = new LinkedList[team1.length];
            for(int i=0; i<team1a.length; i++)
            {
                team1a[i] = new LinkedList<>();
                for(int j=0; j<team1[i].length; j++)
                    team1a[i].add(Integer.parseInt(team1[i][j]));
            }
            SE1Hard = new CSE1[se1hard];
            SE1Soft = new CSE1[se1soft];
            int h = 0;
            int s = 0;
            for(int i=0; i<SE1.size(); i++)
            {
                if(SE1.get(i)[3].equalsIgnoreCase("HARD")) {
                    SE1Hard[h] = new CSE1(Integer.parseInt(SE1.get(i)[0]), Integer.parseInt(SE1.get(i)[1]),
                            team1a[i]);
                    h++;
                }
                else {
                    SE1Soft[s] = new CSE1(Integer.parseInt(SE1.get(i)[0]), Integer.parseInt(SE1.get(i)[1]),
                            team1a[i]);
                    s++;
                }
            }
        }
        LinkedList<int[]>[] soltemp = new LinkedList[jumlahslot/2];
        for(int i=0; i<soltemp.length;i++)
            soltemp[i] = new LinkedList<>();

        //////////////////////////////////////////////////SOLUSI TANPA PENGECEKAN HC////////////////////////////////////


        //Declare kombinasi pertandingan
            LinkedList<int[]> combine = new LinkedList<>();
            for (int i = 0; i < jumlahteam - 1; i++) {
                for (int j = i + 1; j < jumlahteam; j++) {
                    int[] a = {i, j};
                    combine.add(a);
                }

        //Pembuatan Jadwal yang lolos Base Constraint
            int start = 0;
            int firststart = 0;
            int home = 0;
            outerloop:
            for (int i = 0; i < combine.size(); i++) {

                if (home == combine.get(i)[0]) {
                    for (int j = start; j < soltemp.length; j++) {
                        if (soltemp[j].isEmpty()) {
                            soltemp[j].add(combine.get(i));
                            start = j;
                            if (combine.get(i)[1] - combine.get(i)[0] == 1)
                                firststart = j;
                            continue outerloop;
                        } else {
                            boolean assign = true;
                            for (int k = 0; k < soltemp[j].size(); k++) {
                                if (soltemp[j].get(k)[0] == combine.get(i)[0] || soltemp[j].get(k)[0] == combine.get(i)[1]
                                        || soltemp[j].get(k)[1] == combine.get(i)[0] || soltemp[j].get(k)[1] == combine.get(i)[1]) {
                                    assign = false;
                                }
                            }
                            if (assign) {
                                soltemp[j].add(combine.get(i));
                                start = j;
                                if (combine.get(i)[1] - combine.get(i)[0] == 1)
                                    firststart = j;
                                continue outerloop;
                            }
                        }
                    }
                    for (int j = 0; j < soltemp.length; j++) {
                        if (soltemp[j].isEmpty()) {
                            soltemp[j].add(combine.get(i));
                            start = j;
                            if (combine.get(i)[1] - combine.get(i)[0] == 1)
                                firststart = j;
                            continue outerloop;
                        } else {
                            boolean assign = true;
                            for (int k = 0; k < soltemp[j].size(); k++) {
                                if (soltemp[j].get(k)[0] == combine.get(i)[0] || soltemp[j].get(k)[0] == combine.get(i)[1]
                                        || soltemp[j].get(k)[1] == combine.get(i)[0] || soltemp[j].get(k)[1] == combine.get(i)[1]) {
                                    assign = false;
                                }
                            }
                            if (assign) {
                                soltemp[j].add(combine.get(i));
                                if (combine.get(i)[1] - combine.get(i)[0] == 1)
                                    firststart = j;
                                start = j;
                                continue outerloop;
                            }
                        }
                    }
                } else {
                    home++;
                    for (int j = firststart; j < soltemp.length; j++) {
                        if (soltemp[j].isEmpty()) {
                            soltemp[j].add(combine.get(i));
                            start = j;
                            if (combine.get(i)[1] - combine.get(i)[0] == 1)
                                firststart = j;
                            continue outerloop;
                        } else {
                            boolean assign = true;
                            for (int k = 0; k < soltemp[j].size(); k++) {
                                if (soltemp[j].get(k)[0] == combine.get(i)[0] || soltemp[j].get(k)[0] == combine.get(i)[1]
                                        || soltemp[j].get(k)[1] == combine.get(i)[0] || soltemp[j].get(k)[1] == combine.get(i)[1]) {
                                    assign = false;
                                }
                            }
                            if (assign) {
                                soltemp[j].add(combine.get(i));
                                start = j;
                                if (combine.get(i)[1] - combine.get(i)[0] == 1)
                                    firststart = j;
                                continue outerloop;
                            }
                        }
                    }
                    for (int j = 0; j < soltemp.length; j++) {
                        if (soltemp[j].isEmpty()) {
                            soltemp[j].add(combine.get(i));
                            start = j;
                            if (combine.get(i)[1] - combine.get(i)[0] == 1)
                                firststart = j;
                            continue outerloop;
                        } else {
                            boolean assign = true;
                            for (int k = 0; k < soltemp[j].size(); k++) {
                                if (soltemp[j].get(k)[0] == combine.get(i)[0] || soltemp[j].get(k)[0] == combine.get(i)[1]
                                        || soltemp[j].get(k)[1] == combine.get(i)[0] || soltemp[j].get(k)[1] == combine.get(i)[1]) {
                                    assign = false;
                                }
                            }
                            if (assign) {
                                soltemp[j].add(combine.get(i));
                                if (combine.get(i)[1] - combine.get(i)[0] == 1)
                                    firststart = j;
                                start = j;
                                continue outerloop;
                            }
                        }
                    }
                }
            }

            // Optimasi (Minimasi) Hard Constraint Hingga 0
            int pen = countPenalty("HARD", solutions)[0];
            int[] fitness = new int[100];
            for(int i=0;i<fitness.length;i++)
                fitness[i] = countPenalty("HARD", solutions)[0];
            int x = countPenalty("HARD", solutions)[0];
            int i =0;
            while(x>0)
            {
                LinkedList<Integer> tabu = new LinkedList<Integer>();
                int rand=-1;
                do {
                    rand = (int) (Math.random() * 4);
                }while (tabu.contains(rand));
                if(rand==0)
                    roundSwap(solutions);
                if(rand==1)
                    swapHome(solutions);
                if(rand==2)
                    teamSwap(solutions);
                if(rand==3)
                    round3Swap(solutions);
                x = countPenalty("HARD", solutions)[0];
                if(x<=fitness[i%100])
                {
                    copySolution(iteration, solutions);
                    x = countPenalty("HARD", solutions)[0];
//                pen = x;
                    fitness[i%100] = x;
                }
                else {
                    copySolution(solutions, iteration);
                    x=countPenalty("HARD", solutions)[0];
//                pen = x;
                    tabu.add(rand);
                    if(tabu.size()>3)
                        tabu.pollFirst();
                }

                System.out.println(i+" " + x);
                i++;
            }

            System.out.println(countPenalty("HARD", solutions)[0]);

            // Tulis Solusi Feasible
        if(tulis==1)
            write(solutions);
    }

    public static void copySolution(LinkedList<int[]>[] before, LinkedList<int[]>[] after)
    {
        for(int i=0; i<before.length;i++)
        {
            for(int j=0; j<before[i].size();j++)
            {
                before[i].get(j)[0] = after[i].get(j)[0];
                before[i].get(j)[1] = after[i].get(j)[1];
            }
        }
    }

    public static int[] countPenalty(String constraint, LinkedList<int[]>[] solution)
    {
        int [] obj = {0,0};
        int[][] objtemp = new int[9][2];
        objtemp[0] = countCA1(constraint, solution);
        objtemp[1] = countCA2(constraint, solution);
        objtemp[2] = countCA3(constraint, solution);
        objtemp[3] = countCA4(constraint, solution);
        objtemp[4] = countGA1(constraint, solution);
        objtemp[5] = countBR1(constraint, solution);
        objtemp[6] = countBR2(constraint, solution);
        objtemp[7] = countFA2(constraint, solution);
        objtemp[8] = countSE1(constraint, solution);
        for(int i=0; i<objtemp.length;i++) {
            obj[0] += objtemp[i][0];
            obj[1] += objtemp[i][1];
        }
        return obj;
    }

    public static boolean checkBA(LinkedList<int[]>[] temp)
    {
        boolean x = true;
        outerloop:
        for(int i=0; i<temp.length;i++)
        {
            for(int j=0; j<temp[i].size()-1;j++)
            {
                for(int k=j+1; k<temp[i].size() ; k++)
                {
                    if(temp[i].get(j)[0]==temp[i].get(k)[0]||temp[i].get(j)[0]==temp[i].get(k)[1]||
                            temp[i].get(j)[1]==temp[i].get(k)[0]||temp[i].get(j)[1]==temp[i].get(k)[1]) {
                        x=false;
                        break outerloop;
                    }
                }
            }
        }
        return x;
    }

    public static int[] countCA1(String constraint, LinkedList<int[]>[] solution)
    {
        int[] obj = {0, 0};
        int dev =0;
        if(!constraint.equalsIgnoreCase("SOFT")&&ca1hard>0) {
            for (int i = 0; i < CA1Hard.length; i++) {
                for (int j = 0; j < CA1Hard[i].teams.size(); j++) {
                    int temp = 0;
                    for (int k = 0; k < CA1Hard[i].slots.size(); k++) {
                        for (int l = 0; l < solution[CA1Hard[i].slots.get(k)].size(); l++) {
                            if (!CA1Hard[i].mode.equalsIgnoreCase("A"))
                                if (solution[CA1Hard[i].slots.get(k)].get(l)[0] == CA1Hard[i].teams.get(j))
                                    temp++;
                            if (!CA1Hard[i].mode.equalsIgnoreCase("H"))
                                if (solution[CA1Hard[i].slots.get(k)].get(l)[1] == CA1Hard[i].teams.get(j))
                                    temp++;
                        }
                    }
                    if (temp > CA1Hard[i].getMax())
                        dev = dev + ((temp - CA1Hard[i].getMax()) * CA1Hard[i].getPenalty());
                    if (temp < CA1Hard[i].getMin())
                        dev = dev + ((CA1Hard[i].getMin() - temp) * CA1Hard[i].getPenalty());
                }
            }
        }
        obj[0] = dev;
        dev = 0;
        if(!constraint.equalsIgnoreCase("HARD")&&ca1soft>0)
        {
            for (int i = 0; i < CA1Soft.length; i++) {
                for (int j = 0; j < CA1Soft[i].teams.size(); j++) {
                    int temp = 0;
                    for (int k = 0; k < CA1Soft[i].slots.size(); k++) {
                        for (int l = 0; l < solution[CA1Soft[i].slots.get(k)].size(); l++) {
                            if (!CA1Soft[i].mode.equalsIgnoreCase("A"))
                                if (solution[CA1Soft[i].slots.get(k)].get(l)[0] == CA1Soft[i].teams.get(j))
                                    temp++;
                            if (!CA1Soft[i].mode.equalsIgnoreCase("H"))
                                if (solution[CA1Soft[i].slots.get(k)].get(l)[1] == CA1Soft[i].teams.get(j))
                                    temp++;
                        }
                    }
                    if (temp > CA1Soft[i].getMax())
                        dev = dev + ((temp - CA1Soft[i].getMax()) * CA1Soft[i].getPenalty());
                    if (temp < CA1Soft[i].getMin())
                        dev = dev + ((CA1Soft[i].getMin() - temp) * CA1Soft[i].getPenalty());
                }
            }
        }
        obj[1] = dev;
        return obj;
    }

    public static int[] countCA2(String constraint, LinkedList<int[]>[] solution)
    {
        int[] obj = {0, 0};
        int dev = 0;
        if(!constraint.equalsIgnoreCase("SOFT")&&ca2hard>0) {
            for (int i = 0; i < CA2Hard.length; i++) {
                for (int j = 0; j < CA2Hard[i].teams1.size(); j++) {
                    int temp = 0;
                    for (int k = 0; k < CA2Hard[i].slots.size(); k++) {
                        for (int l = 0; l < solution[CA2Hard[i].slots.get(k)].size(); l++) {
                            for (int m = 0; m < CA2Hard[i].teams2.size(); m++) {
                                if (!CA2Hard[i].mode1.equalsIgnoreCase("A"))
                                    if (solution[CA2Hard[i].slots.get(k)].get(l)[0] == CA2Hard[i].teams1.get(j) &&
                                            solution[CA2Hard[i].slots.get(k)].get(l)[1] == CA2Hard[i].teams2.get(m))
                                        temp++;
                                if (!CA2Hard[i].mode1.equalsIgnoreCase("H"))
                                    if (solution[CA2Hard[i].slots.get(k)].get(l)[1] == CA2Hard[i].teams1.get(j) &&
                                            solution[CA2Hard[i].slots.get(k)].get(l)[0] == CA2Hard[i].teams2.get(m))
                                        temp++;
                            }
                        }
                    }
                    if (temp > CA2Hard[i].getMax())
                        dev = dev + ((temp - CA2Hard[i].getMax()) * CA2Hard[i].getPenalty());
                    if (temp < CA2Hard[i].getMin())
                        dev = dev + ((CA2Hard[i].getMin() - temp) * CA2Hard[i].getPenalty());
                }
            }
        }
        obj[0] = dev;
        dev = 0;
        if(!constraint.equalsIgnoreCase("HARD")&&ca2soft>0)
        {
            for (int i = 0; i < CA2Soft.length; i++) {
                for (int j = 0; j < CA2Soft[i].teams1.size(); j++) {
                    int temp = 0;
                    for (int k = 0; k < CA2Soft[i].slots.size(); k++) {
                        for (int l = 0; l < solution[CA2Soft[i].slots.get(k)].size(); l++) {
                            for (int m = 0; m < CA2Soft[i].teams2.size(); m++) {
                                if (!CA2Soft[i].mode1.equalsIgnoreCase("A"))
                                    if (solution[CA2Soft[i].slots.get(k)].get(l)[0] == CA2Soft[i].teams1.get(j) &&
                                            solution[CA2Soft[i].slots.get(k)].get(l)[1] == CA2Soft[i].teams2.get(m))
                                        temp++;
                                if (!CA2Soft[i].mode1.equalsIgnoreCase("H"))
                                    if (solution[CA2Soft[i].slots.get(k)].get(l)[1] == CA2Soft[i].teams1.get(j) &&
                                            solution[CA2Soft[i].slots.get(k)].get(l)[0] == CA2Soft[i].teams2.get(m))
                                        temp++;
                            }
                        }
                    }
                    if (temp > CA2Soft[i].getMax())
                        dev = dev + ((temp - CA2Soft[i].getMax()) * CA2Soft[i].getPenalty());
                    if (temp < CA2Soft[i].getMin())
                        dev = dev + ((CA2Soft[i].getMin() - temp) * CA2Soft[i].getPenalty());
                }
            }
        }
        obj[1] = dev;
        return obj;
    }

    public static int[] countCA3(String constraint, LinkedList<int[]>[] solution)
    {
        int[] obj = {0, 0};
        int dev = 0;
        if(!constraint.equalsIgnoreCase("SOFT")&&ca3hard>0)
        {
            for(int i=0; i<CA3Hard.length; i++)
            {
                for(int j=0; j<CA3Hard[i].teams1.size();j++)
                {
                    int temp =0;
                    for(int k=0; k<=jumlahslot-CA3Hard[i].getIntp();k++)
                    {
                        int temp2 = 0;
                        for(int l=0; l<CA3Hard[i].teams2.size();l++)
                        {
                            for(int m=k; m<k+CA3Hard[i].getIntp();m++)
                            {
                                for(int n=0; n<solution[m].size();n++)
                                {
                                    if(!CA3Hard[i].getMode1().equalsIgnoreCase("A"))
                                        if(solution[m].get(n)[0]==CA3Hard[i].teams1.get(j) &&
                                        solution[m].get(n)[1]==CA3Hard[i].teams2.get(l))
                                        {
                                            temp2++;
                                        }
                                    if(!CA3Hard[i].getMode1().equalsIgnoreCase("H"))
                                        if(solution[m].get(n)[1]==CA3Hard[i].teams1.get(j) &&
                                                solution[m].get(n)[0]==CA3Hard[i].teams2.get(l))
                                        {
                                            temp2++;
                                        }
                                }
                            }
                        }
                        if(temp2<CA3Hard[i].getMin())
                        {
                            temp = temp + (CA3Hard[i].getMin()-temp2);
                        }
                        if(temp2>CA3Hard[i].getMax())
                        {
                            temp = temp + (temp2-CA3Hard[i].getMax());
                        }
                    }
                    dev = dev + (temp * CA3Hard[i].getPenalty());
                }
            }
        }
        obj[0] = dev;
        dev = 0;
        if(!constraint.equalsIgnoreCase("HARD")&&ca3soft>0)
        {
            for(int i=0; i<CA3Soft.length; i++)
            {
                for(int j=0; j<CA3Soft[i].teams1.size();j++)
                {
                    int temp =0;
                    for(int k=0; k<=jumlahslot-CA3Soft[i].getIntp();k++)
                    {
                        int temp2 = 0;
                        for(int l=0; l<CA3Soft[i].teams2.size();l++)
                        {
                            for(int m=k; m<k+CA3Soft[i].getIntp();m++)
                            {
                                for(int n=0; n<solution[m].size();n++)
                                {
                                    if(!CA3Soft[i].getMode1().equalsIgnoreCase("A"))
                                        if(solution[m].get(n)[0]==CA3Soft[i].teams1.get(j) &&
                                                solution[m].get(n)[1]==CA3Soft[i].teams2.get(l))
                                        {
                                            temp2++;
                                        }
                                    if(!CA3Soft[i].getMode1().equalsIgnoreCase("H"))
                                        if(solution[m].get(n)[1]==CA3Soft[i].teams1.get(j) &&
                                                solution[m].get(n)[0]==CA3Soft[i].teams2.get(l))
                                        {
                                            temp2++;
                                        }
                                }
                            }
                        }
                        if(temp2<CA3Soft[i].getMin())
                        {
                            temp = temp + (CA3Soft[i].getMin()-temp2);

                        }
                        if(temp2>CA3Soft[i].getMax())
                        {
                            temp = temp + (temp2-CA3Soft[i].getMax());
                        }
                    }
                    dev = dev + + (temp * CA3Soft[i].getPenalty());
                }
            }
        }
        obj[1] = dev;
        return obj;
    }

    public static int [] countCA4(String constraint, LinkedList<int[]>[] solution)
    {
        int[] obj = {0, 0};
        int dev = 0;
        if(!constraint.equalsIgnoreCase("SOFT")&&ca4hard>0)
        {
            for(int i=0; i<CA4Hard.length;i++)
            {
                int temp = 0;
                for(int j=0; j<CA4Hard[i].slots.size();j++)
                {
                    int temp2 = 0;
                    for(int k=0; k<CA4Hard[i].getTeams1().size();k++)
                    {
                        for(int l=0; l<CA4Hard[i].getTeams2().size();l++)
                        {
                            for(int m=0; m<solution[CA4Hard[i].getSlots().get(j)].size();m++)
                            {
                                if(!CA4Hard[i].getMode1().equalsIgnoreCase("A"))
                                {
                                    if(solution[CA4Hard[i].getSlots().get(j)].get(m)[0]==
                                    CA4Hard[i].getTeams1().get(k)&&
                                            solution[CA4Hard[i].getSlots().get(j)].get(m)[1]==
                                                    CA4Hard[i].getTeams2().get(l))
                                    {
                                        if(CA4Hard[i].getMode2().equalsIgnoreCase("EVERY"))
                                            temp2++;
                                        else
                                            temp++;
                                    }
                                }
                                if(!CA4Hard[i].getMode1().equalsIgnoreCase("H"))
                                {
                                    if(solution[CA4Hard[i].getSlots().get(j)].get(m)[1]==
                                            CA4Hard[i].getTeams1().get(k)&&
                                            solution[CA4Hard[i].getSlots().get(j)].get(m)[0]==
                                                    CA4Hard[i].getTeams2().get(l))
                                    {
                                        if(CA4Hard[i].getMode2().equalsIgnoreCase("EVERY"))
                                            temp2++;
                                        else
                                            temp++;
                                    }
                                }
                            }
                        }
                    }
                    if(temp2>CA4Hard[i].getMax()&&CA4Hard[i].getMode2().equalsIgnoreCase("EVERY"))
                        dev = dev + ((temp2-CA4Hard[i].getMax())*CA4Hard[i].getPenalty());
                    if(temp2<CA4Hard[i].getMin()&&CA4Hard[i].getMode2().equalsIgnoreCase("EVERY"))
                        dev = dev + ((CA4Hard[i].getMin()-temp2)*CA4Hard[i].getPenalty());
                }
                if(temp>CA4Hard[i].getMax()&&CA4Hard[i].getMode2().equalsIgnoreCase("GLOBAL"))
                    dev = dev + ((temp-CA4Hard[i].getMax())*CA4Hard[i].getPenalty());
                if(temp<CA4Hard[i].getMin()&&CA4Hard[i].getMode2().equalsIgnoreCase("GLOBAL"))
                    dev = dev + ((CA4Hard[i].getMin()-temp)*CA4Hard[i].getPenalty());
            }
        }
        obj[0] = dev;
        dev = 0;
        if(!constraint.equalsIgnoreCase("HARD")&&ca4soft>0)
        {
            for(int i=0; i<CA4Soft.length;i++)
            {
                int temp = 0;
                for(int j=0; j<CA4Soft[i].slots.size();j++)
                {
                    int temp2 = 0;
                    for(int k=0; k<CA4Soft[i].getTeams1().size();k++)
                    {
                        for(int l=0; l<CA4Soft[i].getTeams2().size();l++)
                        {
                            for(int m=0; m<solution[CA4Soft[i].getSlots().get(j)].size();m++)
                            {
                                if(!CA4Soft[i].getMode1().equalsIgnoreCase("A"))
                                {
                                    if(solution[CA4Soft[i].getSlots().get(j)].get(m)[0]==
                                            CA4Soft[i].getTeams1().get(k)&&
                                            solution[CA4Soft[i].getSlots().get(j)].get(m)[1]==
                                                    CA4Soft[i].getTeams2().get(l))
                                    {
                                        if(CA4Soft[i].getMode2().equalsIgnoreCase("EVERY"))
                                            temp2++;
                                        else
                                            temp++;
                                    }
                                }
                                if(!CA4Soft[i].getMode1().equalsIgnoreCase("H"))
                                {
                                    if(solution[CA4Soft[i].getSlots().get(j)].get(m)[1]==
                                            CA4Soft[i].getTeams1().get(k)&&
                                            solution[CA4Soft[i].getSlots().get(j)].get(m)[0]==
                                                    CA4Soft[i].getTeams2().get(l))
                                    {
                                        if(CA4Soft[i].getMode2().equalsIgnoreCase("EVERY"))
                                            temp2++;
                                        else
                                            temp++;
                                    }
                                }
                            }
                        }
                    }
                    if(temp2>CA4Soft[i].getMax()&&CA4Soft[i].getMode2().equalsIgnoreCase("EVERY"))
                        dev = dev + ((temp2-CA4Soft[i].getMax())*CA4Soft[i].getPenalty());
                    if(temp2<CA4Soft[i].getMin()&&CA4Soft[i].getMode2().equalsIgnoreCase("EVERY"))
                        dev = dev + ((CA4Soft[i].getMin()-temp2)*CA4Soft[i].getPenalty());
                }
                if(temp>CA4Soft[i].getMax()&&CA4Soft[i].getMode2().equalsIgnoreCase("GLOBAL"))
                    dev = dev + ((temp-CA4Soft[i].getMax())*CA4Soft[i].getPenalty());
                if(temp<CA4Soft[i].getMin()&&CA4Soft[i].getMode2().equalsIgnoreCase("GLOBAL"))
                    dev = dev + ((CA4Soft[i].getMin()-temp)*CA4Soft[i].getPenalty());
            }
        }
        obj[1] = dev;
        return obj;
    }

    public static int[] countGA1(String constraint, LinkedList<int[]>[] solution)
    {
        int[] obj = {0, 0};
        int dev = 0;
        if(!constraint.equalsIgnoreCase("SOFT")&&ga1hard>0) {
            for (int i = 0; i < GA1Hard.length; i++) {
                int temp = 0;
                for (int j = 0; j < GA1Hard[i].meetings.size(); j++) {
                    for (int l = 0; l < GA1Hard[i].slots.size(); l++) {
                        for (int m = 0; m < solution[GA1Hard[i].slots.get(l)].size(); m++) {
                            if (solution[GA1Hard[i].slots.get(l)].get(m)[0] == GA1Hard[i].meetings.get(j)[0] &&
                                    solution[GA1Hard[i].slots.get(l)].get(m)[1] == GA1Hard[i].meetings.get(j)[1]) {
                                temp++;
                            }
                        }
                    }
                }
                if (temp < GA1Hard[i].getMin())
                    dev = dev + ((GA1Hard[i].getMin() - temp) * GA1Hard[i].getPenalty());
                if (temp > GA1Hard[i].getMax())
                    dev = dev + ((temp - GA1Hard[i].getMax()) * GA1Hard[i].getPenalty());
            }
            obj[0] = dev;
            dev = 0;
        }
        if(!constraint.equalsIgnoreCase("HARD")&&ga1soft>0)
        {
            for (int i = 0; i < GA1Soft.length; i++) {
                int temp = 0;
                for (int j = 0; j < GA1Soft[i].meetings.size(); j++) {
                    for (int l = 0; l < GA1Soft[i].slots.size(); l++) {
                        for (int m = 0; m < solution[GA1Soft[i].slots.get(l)].size(); m++) {
                            if (solution[GA1Soft[i].slots.get(l)].get(m)[0] == GA1Soft[i].meetings.get(j)[0] &&
                                    solution[GA1Soft[i].slots.get(l)].get(m)[1] == GA1Soft[i].meetings.get(j)[1]) {
                                temp++;
                            }
                        }
                    }
                }
                if (temp < GA1Soft[i].getMin())
                    dev = dev + ((GA1Soft[i].getMin() - temp) * GA1Soft[i].getPenalty());
                if (temp > GA1Soft[i].getMax())
                    dev = dev + ((temp - GA1Soft[i].getMax()) * GA1Soft[i].getPenalty());
            }
            obj[1] = dev;
        }
        return obj;
    }

    public static int[] countBR1(String constraint, LinkedList<int[]>[] solution)
    {
        int[] obj = {0, 0};
        int dev = 0;
        if(!constraint.equalsIgnoreCase("SOFT")&&br1hard>0)
        {
            for(int i=0; i<BR1Hard.length;i++)
            {
                for(int j=0; j<BR1Hard[i].getTeams().size();j++)
                {
                    int temp =0;
                    for(int k=0; k<BR1Hard[i].getSlots().size();k++)
                    {
                        if(BR1Hard[i].getSlots().get(k)==0)
                            continue;
                        if(!BR1Hard[i].getMode2().equalsIgnoreCase("A")) {
                            boolean now = false;
                            boolean last = false;
                            for (int l = 0; l < solution[BR1Hard[i].getSlots().get(k)].size(); l++) {
                                if (BR1Hard[i].getTeams().get(j) == solution[BR1Hard[i].getSlots().get(k)].get(l)[0]) {
                                    now = true;
                                    break;
                                }
                            }
                            for (int l = 0; l < solution[(BR1Hard[i].getSlots().get(k)) - 1].size(); l++) {
                                if (BR1Hard[i].getTeams().get(j) == solution[(BR1Hard[i].getSlots().get(k)) - 1].get(l)[0]) {
                                    last = true;
                                    break;
                                }
                            }
                            if (now&&last)
                                temp++;
                        }
                        if(!BR1Hard[i].getMode2().equalsIgnoreCase("H")) {
                            boolean now = false;
                            boolean last = false;
                            for (int l = 0; l < solution[BR1Hard[i].getSlots().get(k)].size(); l++) {
                                if (BR1Hard[i].getTeams().get(j) == solution[BR1Hard[i].getSlots().get(k)].get(l)[1]) {
                                    now = true;
                                    break;
                                }
                            }
                            for (int l = 0; l < solution[(BR1Hard[i].getSlots().get(k)) - 1].size(); l++) {
                                if (BR1Hard[i].getTeams().get(j) == solution[(BR1Hard[i].getSlots().get(k)) - 1].get(l)[1]) {
                                    last = true;
                                    break;
                                }
                            }
                            if (now&&last)
                                temp++;
                        }
                    }
                    if(temp>BR1Hard[i].getIntp())
                        dev=dev+((temp-BR1Hard[i].getIntp())*BR1Hard[i].getPenalty());
                }
            }
        }
        obj[0] = dev;
        dev = 0;
        if(!constraint.equalsIgnoreCase("HARD")&&br1soft>0)
        {
            for(int i=0; i<BR1Soft.length;i++)
            {
                for(int j=0; j<BR1Soft[i].getTeams().size();j++)
                {
                    int temp =0;
                    for(int k=0; k<BR1Soft[i].getSlots().size();k++)
                    {
                        if(BR1Soft[i].getSlots().get(k)==0)
                            continue;
                        if(!BR1Soft[i].getMode2().equalsIgnoreCase("A")) {
                            boolean now = false;
                            boolean last = false;
                            for (int l = 0; l < solution[BR1Soft[i].getSlots().get(k)].size(); l++) {
                                if (BR1Soft[i].getTeams().get(j) == solution[BR1Soft[i].getSlots().get(k)].get(l)[0]) {
                                    now = true;
                                    break;
                                }
                            }
                            for (int l = 0; l < solution[(BR1Soft[i].getSlots().get(k)) - 1].size(); l++) {
                                if (BR1Soft[i].getTeams().get(j) == solution[(BR1Soft[i].getSlots().get(k)) - 1].get(l)[0]) {
                                    last = true;
                                    break;
                                }
                            }
                            if (now&&last)
                                temp++;
                        }
                        if(!BR1Soft[i].getMode2().equalsIgnoreCase("H")) {
                            boolean now = false;
                            boolean last = false;
                            for (int l = 0; l < solution[BR1Soft[i].getSlots().get(k)].size(); l++) {
                                if (BR1Soft[i].getTeams().get(j) == solution[BR1Soft[i].getSlots().get(k)].get(l)[1]) {
                                    now = true;
                                    break;
                                }
                            }
                            for (int l = 0; l < solution[(BR1Soft[i].getSlots().get(k)) - 1].size(); l++) {
                                if (BR1Soft[i].getTeams().get(j) == solution[(BR1Soft[i].getSlots().get(k)) - 1].get(l)[1]) {
                                    last = true;
                                    break;
                                }
                            }
                            if (now&&last)
                                temp++;
                        }
                    }
                    if(temp>BR1Soft[i].getIntp())
                        dev=dev+((temp-BR1Soft[i].getIntp())*BR1Soft[i].getPenalty());
                }
            }
        }
        obj[1] = dev;
        return obj;
    }

    public static int[] countBR2(String constraint, LinkedList<int[]>[] solution)
    {
        int[] obj = {0, 0};
        int dev = 0;
        if(!constraint.equalsIgnoreCase("SOFT")&&br2hard>0)
        {
            for(int i=0; i<BR2Hard.length;i++)
            {
                int temp =0;
                for(int j=0; j<BR2Hard[i].getTeams().size();j++)
                {
                    for(int k=0; k<BR2Hard[i].getSlots().size();k++)
                    {
                        if(BR2Hard[i].getSlots().get(k)==0)
                            continue;
                        boolean now = false;
                        boolean last = false;
                        for (int l = 0; l < solution[BR2Hard[i].getSlots().get(k)].size(); l++) {
                            if (BR2Hard[i].getTeams().get(j) == solution[BR2Hard[i].getSlots().get(k)].get(l)[0]) {
                                now = true;
                                break;
                            }
                        }
                        for (int l = 0; l < solution[(BR2Hard[i].getSlots().get(k)) - 1].size(); l++) {
                            if (BR2Hard[i].getTeams().get(j) == solution[(BR2Hard[i].getSlots().get(k)) - 1].get(l)[0]) {
                                last = true;
                                break;
                            }
                        }
                        if (now&&last) {
                            temp++;
                            continue;
                        }
                        now = false;
                        last = false;
                        for (int l = 0; l < solution[BR2Hard[i].getSlots().get(k)].size(); l++) {
                            if (BR2Hard[i].getTeams().get(j) == solution[BR2Hard[i].getSlots().get(k)].get(l)[1]) {
                                now = true;
                                break;
                            }
                        }
                        for (int l = 0; l < solution[(BR2Hard[i].getSlots().get(k)) - 1].size(); l++) {
                            if (BR2Hard[i].getTeams().get(j) == solution[(BR2Hard[i].getSlots().get(k)) - 1].get(l)[1]) {
                                last = true;
                                break;
                            }
                        }
                        if (now&&last)
                            temp++;
                    }
                }
                if(temp>BR2Hard[i].getIntp())
                    dev=dev+((temp-BR2Hard[i].getIntp())*BR2Hard[i].getPenalty());
            }
        }
        obj[0] = dev;
        dev = 0;
        if(!constraint.equalsIgnoreCase("HARD")&&br2soft>0)
        {
            for(int i=0; i<BR2Soft.length;i++)
            {
                int temp =0;
                for(int j=0; j<BR2Soft[i].getTeams().size();j++)
                {
                    for(int k=0; k<BR2Soft[i].getSlots().size();k++)
                    {
                        if(BR2Soft[i].getSlots().get(k)==0)
                            continue;
                        boolean now = false;
                        boolean last = false;
                        for (int l = 0; l < solution[BR2Soft[i].getSlots().get(k)].size(); l++) {
                            if (BR2Soft[i].getTeams().get(j) == solution[BR2Soft[i].getSlots().get(k)].get(l)[0]) {
                                now = true;
                                break;
                            }
                        }
                        for (int l = 0; l < solution[(BR2Soft[i].getSlots().get(k)) - 1].size(); l++) {
                            if (BR2Soft[i].getTeams().get(j) == solution[(BR2Soft[i].getSlots().get(k)) - 1].get(l)[0]) {
                                last = true;
                                break;
                            }
                        }
                        if (now&&last) {
                            temp++;
                            continue;
                        }
                        now = false;
                        last = false;
                        for (int l = 0; l < solution[BR2Soft[i].getSlots().get(k)].size(); l++) {
                            if (BR2Soft[i].getTeams().get(j) == solution[BR2Soft[i].getSlots().get(k)].get(l)[1]) {
                                now = true;
                                break;
                            }
                        }
                        for (int l = 0; l < solution[(BR2Soft[i].getSlots().get(k)) - 1].size(); l++) {
                            if (BR2Soft[i].getTeams().get(j) == solution[(BR2Soft[i].getSlots().get(k)) - 1].get(l)[1]) {
                                last = true;
                                break;
                            }
                        }
                        if (now&&last)
                            temp++;
                    }
                }
                if(temp>BR2Soft[i].getIntp())
                    dev=dev+((temp-BR2Soft[i].getIntp())*BR2Soft[i].getPenalty());
            }
        }
        obj[1] = dev;
        return obj;
    }
    
    public static int[] countFA2(String constraint, LinkedList<int[]>[] solution)
    {
        int []obj = {0,0};
        int dev =0;
        if(!constraint.equalsIgnoreCase("SOFT")&&fa2hard>0)
        {
            for(int i=0; i<FA2Hard.length;i++)
            {
                for(int j=0; j<FA2Hard[i].getTeams().size()-1;j++)
                {
                    for(int k=j+1; k<FA2Hard[i].getTeams().size();k++)
                    {
                        int max = 0;
                        for(int l=0; l<FA2Hard[i].getSlots().size();l++)
                        {
                            int home1 = 0;
                            int home2 = 0;
                            for(int m=0; m<FA2Hard[i].getSlots().get(l);m++)
                            {
                                for(int n=0; n<solution[m].size();n++)
                                {
                                    if(solution[m].get(n)[0]==FA2Hard[i].getTeams().get(j))
                                        home1++;
                                    if(solution[m].get(n)[0]==FA2Hard[i].getTeams().get(k))
                                        home2++;
                                }
                            }
                            if(Math.abs(home1-home2)>max)
                                max = Math.abs(home1-home2);
                        }
                        if(max>FA2Hard[i].getIntp())
                            dev = dev+((max-FA2Hard[i].getIntp())*FA2Hard[i].getPenalty());
                    }
                }
            }
        }
        obj[0] = dev;
        dev = 0;
        if(!constraint.equalsIgnoreCase("HARD")&&fa2soft>0)
        {
            for(int i=0; i<FA2Soft.length;i++)
            {
                for(int j=0; j<FA2Soft[i].getTeams().size()-1;j++)
                {
                    for(int k=j+1; k<FA2Soft[i].getTeams().size();k++)
                    {
                        int max = 0;
                        for(int l=0; l<FA2Soft[i].getSlots().size();l++)
                        {
                            int home1 = 0;
                            int home2 = 0;
                            for(int m=0; m<FA2Soft[i].getSlots().get(l);m++)
                            {
                                for(int n=0; n<solution[m].size();n++)
                                {
                                    if(solution[m].get(n)[0]==FA2Soft[i].getTeams().get(j))
                                        home1++;
                                    if(solution[m].get(n)[0]==FA2Soft[i].getTeams().get(k))
                                        home2++;
                                }
                            }
                            if(Math.abs(home1-home2)>max)
                                max = Math.abs(home1-home2);
                        }
                        if(max>FA2Soft[i].getIntp())
                            dev = dev+((max-FA2Soft[i].getIntp())*FA2Soft[i].getPenalty());
                    }
                }
            }
        }
        obj[1] = dev;
        return obj;
    }

    public static int[] countSE1(String constraint, LinkedList<int[]>[] solution)
    {
        int[] obj = {0,0};
        int dev =0;
        if(!constraint.equalsIgnoreCase("SOFT")&&se1hard>0)
        {
            for(int i=0; i<SE1Hard.length;i++)
            {
                for(int j=0; j<SE1Hard[i].getTeams().size()-1;j++)
                {
                    int temp =0;
                    int s1 = -1;
                    int s2 = -1;
                    for(int k=j+1; k<SE1Hard[i].getTeams().size();k++)
                    {
                        int index = 0;
                        loop:
                        for(int l=0; l<solution.length;l++)
                        {

                            for(int m=0; m<solution[l].size();m++)
                            {
                                if((solution[l].get(m)[0]==SE1Hard[i].getTeams().get(j)&&
                                        solution[l].get(m)[1]==SE1Hard[i].getTeams().get(k))||
                                        (solution[l].get(m)[1]==SE1Hard[i].getTeams().get(j)&&
                                                solution[l].get(m)[0]==SE1Hard[i].getTeams().get(k))) {
                                    index++;
                                    if(index==1) {
                                        s1 = l;
                                        continue loop;
                                    }
                                    if(index==2)
                                    {
                                        s2 = l;
                                        break loop;
                                    }
                                }
                            }
                        }
                        if(s1>s2)
                            temp = SE1Hard[i].getMin() - (s1 - s2 - 1);
                        if(s2>s1)
                            temp = SE1Hard[i].getMin()-(s2-s1-1);
                        if(temp>0)
                            dev = dev + (temp*SE1Hard[i].getPenalty());
                    }
                }
            }
        }
        obj[0] = dev;
        dev = 0;
        if(!constraint.equalsIgnoreCase("HARD")&&se1soft>0)
        {
            for(int i=0; i<SE1Soft.length;i++)
            {
                for(int j=0; j<SE1Soft[i].getTeams().size()-1;j++)
                {
                    int temp =0;
                    int s1 = -1;
                    int s2 = -1;
                    for(int k=j+1; k<SE1Soft[i].getTeams().size();k++)
                    {
                        int index = 0;
                        loop:
                        for(int l=0; l<solution.length;l++)
                        {

                            for(int m=0; m<solution[l].size();m++)
                            {
                                if((solution[l].get(m)[0]==SE1Soft[i].getTeams().get(j)&&
                                        solution[l].get(m)[1]==SE1Soft[i].getTeams().get(k))||
                                        (solution[l].get(m)[1]==SE1Soft[i].getTeams().get(j)&&
                                        solution[l].get(m)[0]==SE1Soft[i].getTeams().get(k))) {
                                    index++;
                                    if(index==1) {
                                        s1 = l;
                                        continue loop;
                                    }
                                    if(index==2)
                                    {
                                        s2 = l;
                                        break loop;
                                    }
                                }
                            }
                        }
                        if(s1>s2)
                            temp = SE1Soft[i].getMin() - (s1 - s2 - 1);
                        if(s2>s1)
                            temp = SE1Soft[i].getMin()-(s2-s1-1);
                        if(temp>0)
                            dev = dev + (temp*SE1Soft[i].getPenalty());
                    }
                }
            }
        }
        obj[1] = dev;
        return obj;
    }

    public static void teamSwap(LinkedList<int[]>[] solution)
    {
        int rand1 = (int) (Math.random()*jumlahteam);
        int rand2 = -1;
        do{
            rand2 = (int) (Math.random()*jumlahteam);
        }while(rand2==rand1);
        for(int i=0; i<solution.length;i++)
        {
            for(int j=0; j<solution[i].size();j++)
            {
                if(solution[i].get(j)[0]==rand1)
                    if(solution[i].get(j)[1]!=rand2)
                    {
                        solution[i].get(j)[0]=rand2;
                        continue;
                    }
                if(solution[i].get(j)[0]==rand2)
                    if(solution[i].get(j)[1]!=rand1)
                    {
                        solution[i].get(j)[0]=rand1;
                        continue;
                    }
                if(solution[i].get(j)[1]==rand1)
                    if(solution[i].get(j)[0]!=rand2)
                    {
                        solution[i].get(j)[1]=rand2;
                        continue;
                    }
                if(solution[i].get(j)[1]==rand2)
                    if(solution[i].get(j)[0]!=rand1)
                    {
                        solution[i].get(j)[1]=rand1;
                        continue;
                    }
            }
        }
    }

    public static void reTeamSwap(LinkedList<int[]>[] solution, int team1, int team2)
    {
        for(int i=0; i<solution.length;i++)
        {
            for(int j=0; j<solution[i].size();j++)
            {
                if(solution[i].get(j)[0]==team1)
                    if(solution[i].get(j)[1]!=team2)
                    {
                        solution[i].get(j)[0]=team2;
                        continue;
                    }
                if(solution[i].get(j)[0]==team2)
                    if(solution[i].get(j)[1]!=team1)
                    {
                        solution[i].get(j)[0]=team1;
                        continue;
                    }
                if(solution[i].get(j)[1]==team1)
                    if(solution[i].get(j)[0]!=team2)
                    {
                        solution[i].get(j)[1]=team2;
                        continue;
                    }
                if(solution[i].get(j)[1]==team2)
                    if(solution[i].get(j)[0]!=team1)
                    {
                        solution[i].get(j)[1]=team1;
                        continue;
                    }
            }
        }
    }

    public static void roundSwap(LinkedList<int[]>[] solution)
    {
        int rand1=-1;
        int rand2=-1;
        if(phased) {
            rand1 = (int) (Math.random() * jumlahslot);
            if (rand1 < jumlahslot / 2) {
                do {
                    rand2 = (int) (Math.random() * (jumlahslot / 2));
                } while (rand1 == rand2);
            } else {
                do {
                    rand2 = (int) ((Math.random() * (jumlahslot / 2)) + (jumlahslot / 2));
                } while (rand1 == rand2);
            }
        }
        if(!phased)
        {
            rand1 = (int) (Math.random()*jumlahslot);
            do{
                rand2 =(int) (Math.random()*jumlahslot);
            }while (rand2==rand1);
        }
        for(int i=0; i<jumlahteam/2;i++)
        {
            solution[rand1].add(solution[rand2].get(i));
            solution[rand2].add(solution[rand1].get(i));
        }
        for(int i=0; i<jumlahteam/2;i++)
        {
            solution[rand1].pollFirst();
            solution[rand2].pollFirst();
        }
    }

    public static void reRoundSwap(LinkedList<int[]>[] solution, int round1, int round2)
    {
        int rand1=-1;
        int rand2=-1;
        if(phased) {
            rand1 = (int) (Math.random() * jumlahslot);
            if (rand1 < jumlahslot / 2) {
                do {
                    rand2 = (int) (Math.random() * (jumlahslot / 2));
                } while (rand1 == rand2);
            } else {
                do {
                    rand2 = (int) ((Math.random() * (jumlahslot / 2)) + (jumlahslot / 2));
                } while (rand1 == rand2);
            }
        }
        if(!phased)
        {
            rand1 = (int) (Math.random()*jumlahslot);
            do{
                rand2 =(int) (Math.random()*jumlahslot);
            }while (rand2==rand1);
        }
        for(int i=0; i<jumlahteam/2;i++)
        {
            solution[rand1].add(solution[rand2].get(i));
            solution[rand2].add(solution[rand1].get(i));
        }
        for(int i=0; i<jumlahteam/2;i++)
        {
            solution[rand1].pollFirst();
            solution[rand2].pollFirst();
        }
    }

    public static void round3Swap(LinkedList<int[]>[] solution)
    {
        int rand1=-1;
        int rand2=-1;
        int rand3=-1;
        if(phased) {
            rand1 = (int) (Math.random() * jumlahslot);
            if (rand1 < jumlahslot / 2) {
                do {
                    rand2 = (int) (Math.random() * (jumlahslot / 2));
                } while (rand1 == rand2);
                do{
                    rand3 = (int) (Math.random() * (jumlahslot/2));
                }while (rand3==rand2 || rand3==rand1);
            } else {
                do {
                    rand2 = (int) ((Math.random() * (jumlahslot / 2)) + (jumlahslot / 2));
                } while (rand1 == rand2);
                do{
                    rand3 = (int) ((Math.random() * (jumlahslot / 2)) + (jumlahslot / 2));
                }while (rand3==rand2 || rand3==rand1);
            }
        }
        if(!phased)
        {
            rand1 = (int) (Math.random()*jumlahslot);
            do{
                rand2 =(int) (Math.random()*jumlahslot);
            }while (rand2==rand1);
            do{
                rand3 =(int) (Math.random()*jumlahslot);
            }while (rand3==rand1||rand3==rand2);
        }
        for(int i=0; i<jumlahteam/2;i++)
        {
            solution[rand1].add(solution[rand2].get(i));
            solution[rand2].add(solution[rand3].get(i));
            solution[rand3].add(solution[rand1].get(i));
        }
        for(int i=0; i<jumlahteam/2;i++)
        {
            solution[rand1].pollFirst();
            solution[rand2].pollFirst();
            solution[rand3].pollFirst();
        }
    }

    public static void swapHome(LinkedList<int[]>[] solution)
    {
        int rand1 = (int) (Math.random()*jumlahteam);
        int rand2 = -1;
        do{
            rand2 = (int) (Math.random()*jumlahteam);
        }while(rand1==rand2);
        for(int i=0; i<solution.length;i++)
        {
            for(int j=0; j<solution[i].size();j++)
            {
                if(solution[i].get(j)[0]==rand1&&solution[i].get(j)[1]==rand2)
                {
                    solution[i].get(j)[0]=rand2;
                    solution[i].get(j)[1]=rand1;
                    continue;
                }
                if(solution[i].get(j)[1]==rand1&&solution[i].get(j)[0]==rand2)
                {
                    solution[i].get(j)[0]=rand1;
                    solution[i].get(j)[1]=rand2;
                    continue;
                }
            }
        }
    }

    public static void write(LinkedList<int[]>[] temp) throws IOException {
        String name = file.getName();
        File files =  new File("E:\\"+"Solution"+name);
        FileWriter writer = new FileWriter("E:\\"+"Solution"+name, false);
        writer.write("<Solution>");
        writer.write("\n");
        writer.write("\t<Metadata>");
        writer.write("\n");
        writer.write("\t\t<InstanceName>"+file.getName()+"</InstanceName>");
        writer.write("\n");
        String f = file.getName().toString();
        writer.write("\t\t<SolutionName>"+f.substring(0, f.length()-4)+"Sol_TeamRRH</SolutionName>");
        writer.write("\n");
        writer.write("\t\t<ObjectiveValue infeasibility="+(char)34+countPenalty("HARD", temp)[0]+(char)34
        +" objective=" +(char)34+countPenalty("SOFT", temp)[1]+(char)34+"/>");
        writer.write("\n");
        writer.write("\t</Metadata>");
        writer.write("\n");
        writer.write("\t<Games>");
        writer.write("\n");
        for(int i=0; i<temp.length;i++)
        {
            for(int j=0; j<temp[i].size();j++)
            {

                String A = "\t\t<ScheduledMatch home=" + (char)34 + temp[i].get(j)[0] + (char)34
                        + " away=" + (char)34 + temp[i].get(j)[1]+ (char)34 + " slot=" + (char)34 +
                        i+(char)34 + "/>";
                writer.write(A);
//                if(!(i==temp.length-1&&j==temp[i].size()-1))
                writer.write("\n");
            }
        }
        writer.write("\t</Games>");
        writer.write("\n");
        writer.write("</Solution>");

        writer.close();
    }
}