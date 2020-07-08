

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution200620 {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    float[] exchange = {100.00f, 50.00f, 20.00f, 10.00f, 5.00f, 2.00f, 1.00f, 0.50f, 0.25f, 0.10f, 0.05f, 0.01f};
    String[] name = {"ONE HUNDRED", "FIFTY", "TWENTY", "TEN", "FIVE", "TWO", "ONE", "HALF DOLLAR", "QUARTER", "DIME", "NICKEL", "PENNY"};
    String line;
    while ((line = in.readLine()) != null) {
    	String[] money = line.split(";");
    	if(money.length<2) {
    		System.out.println("ERROR");
    		continue;
    	}
    	float PP = Float.parseFloat(money[0]);
    	float CH = Float.parseFloat(money[1]);

    	if(CH<PP)System.out.println("ERROR");
    	if(CH==PP)System.out.println("ZERO");
    	String print="";
    	float left=CH-PP;
    	int is=0;
    	while(left>0.01) {
    		// find index
    		for(int i=is;i<exchange.length;i++) {
    			if(left>=exchange[i]) {
    				is=i;
    				break;
    			}
    		}
    		// prepare for next
    		while(left>=exchange[is])left -= exchange[is];
    		print += name[is];
    		if(left>0.01) print += ",";
    		
    	}
        System.out.println(print);
      
    }
  }
}

//キャッシュレジスター
//プログラミング チャレンジの説明:
//この課題では、キャッシュレジスター（レジ）のプログラムを設計します。2桁の十進数が与えられます。1つ目はアイテムの購入価格（Purchase Price: PP）です。2つ目は顧客が支払った現金（Cash: CH）です。 現在、レジの中には以下の紙幣と硬貨があります：
//
//'PENNY': .01, 
//'NICKEL': .05, 
//'DIME': .10,
//'QUARTER': .25,
//'HALF DOLLAR': .50,
//'ONE': 1.00,
//'TWO': 2.00,
//'FIVE': 5.00,
//'TEN': 10.00,
//'TWENTY': 20.00,
//'FIFTY': 50.00,
//'ONE HUNDRED': 100.00 
//このプログラムの目的は、顧客にお釣りとして返すべき紙幣/硬貨を計算することです。
//
//入力:
//標準入力から行を読み込む必要があります。各行にはセミコロンで区切られた2つの数値が含まれています。1つ目は購入価格（PP）で、2つ目は顧客が支払った現金（CH）です。
//
//出力:
//入力の各行に対して、顧客に返すお釣りを出力します。CH<PPの場合、ERRORを出力します。CH== PPの場合、ZEROを出力します。その他のケースは、顧客に返すべきお釣りの金額に相当する紙幣/硬貨を出力します。なお、回答はアルファベット順にソートする必要があります。
//
//テスト 1
//テストの入力
//テスト 1 の入力をダウンロード
//15.94;16.00
//期待される出力
//テスト 1 の入力をダウンロード
//NICKEL,PENNY
//テスト 2
//テストの入力
//テスト 2 の入力をダウンロード
//17;16
//期待される出力
//テスト 2 の入力をダウンロード
//ERROR
//テスト 3
//テストの入力
//テスト 3 の入力をダウンロード
//35;35
//期待される出力
//テスト 3 の入力をダウンロード
//ZERO
//テスト 4
//テストの入力
//テスト 4 の入力をダウンロード
//45;50
//期待される出力
//テスト 4 の入力をダウンロード
//FIVE

