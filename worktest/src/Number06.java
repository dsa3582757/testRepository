import java.util.Scanner;
//题6- 日志采集系统
//        日志采集是运维系统的核心组件。日志是按行生成，每行记做一条，由采集系统分批上报。如果上报太频繁，会对服务端造成压力。如果上报太晚，会降低用户的体验，如果一次上报的条数太多，会导致超时失败。为此，项目组设计了如下的上报策略：
//        1、每成功上报一条日志，奖励1分
//        2、每天日志每延长上报1秒，扣1分
//        3、积累日志达到100条，必须立即上报
//        给出日志序列，根据该规则，计算首次上报能获得的最多的积分数
//        输入描述：按时序产生的日志条数 T1 ,T2... Tn ,其中 1<=n<=1000 , 0<=Ti<=100
//        输入描述: 首次上报最多获得的积分数
//        示例1:
//        输入: 50 60 1
//        输出: 50
//        说明: 如果第1个时刻上报，获得积分50 。如果第2个时刻上报，最多上报100条，前50
//        条延迟上报1s，每条扣除1分，共获得积分为100-50=50
public class Number06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int score = 0;
        int index = 0;
        int fre = 0;
        int max = 0;
        for (String s : arr) {
            int tmp = Integer.parseInt(s);
            if ( index == 0 ) {
                score = tmp;
                fre = tmp;
                if(max<score){
                    max = score;
                }
            } else if (fre + tmp < 100) {
                score = tmp - fre;
                fre = fre + tmp;
                if(max < score){
                    max = score;
                }
            } else if (fre + tmp >= 100) {
                score = tmp - fre;
                fre = fre + tmp;
                if(max<score){
                    max = score;
                }
                break;
            }
            index++;
        }
        System.out.println(max);
    }
}
