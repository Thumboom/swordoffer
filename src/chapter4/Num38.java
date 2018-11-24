package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * @author An
 *
 */
public class Num38 {

    public boolean[] visited; //��¼��ʹ�õ�stringArray�е�Ԫ��
    public String[] stringArray;//�洢������ĸ
    public ArrayList list;
    public Set set = new HashSet(); //ȥ���ظ�Ԫ��
    public int sum;  //�ַ�������

    public ArrayList<String> Permutation(String str) {
        init(str);
        for(int i = 0; i < sum; i ++) {
            visited[i] = true;
            fullPermutation(stringArray[i]);
            visited[i] = false;//ȡ�����
        }

        list = new ArrayList<String >(set);
        Collections.sort(list);
        return list;
    }

    public void init(String str){
        sum = str.length();
        stringArray = new String[sum];
        for(int i = 0; i < sum; i ++) {
            stringArray[i] = str.substring(i, i+1);
        }
        visited = new boolean[sum];
    }


    public void fullPermutation(String s){

        if(s.length() == sum) {//�����������Ѿ�������ַ���
            set.add(s);
            return;
        }

        for(int i = 0; i < sum; i++) {
            if(visited[i] == false ) {
                visited[i] = true;
                fullPermutation(s + stringArray[i]);
                visited[i] = false;
            }
        }

    }
    public static void main(String[] args) {
        String str = "bbca";
        Num38 ss = new Num38();
        System.out.println(ss.Permutation(str));
    }
}
