import java.util.ArrayList;
import java.util.List;

public class Cacu {
    //a1X1+a2X2+......+anXn=M;
    //a1到an为各元系数

    /// <summary>
    /// 方程的解的列表
    /// </summary>
    /// <param name="iRatios">各元系数an</param>
    /// <param name="iM">总和</param>
    /// <param name="iXLower">各元的下限</param>
    /// <param name="iXUpper">各元的上限</param>


    public ArrayList<int[]> CacuIt(int[] iRatios, int iM, int iXLower, int iXUpper) {
        ArrayList<int[]> lAnswers = new ArrayList<int[]>();
        if (iXLower * iRatios.length <= iM)//有解
        {
            int[] iXs = new int[iRatios.length];
            for (int I = 0; I < iXs.length; I++) iXs[I] = iXLower;
            boolean blNotEnd = true;
            while (blNotEnd) {
                if (GetCacuState(iRatios, iXs, iM)) {
                    int[] iXt = new int[iRatios.length];
                    for (int I = 0; I < iXt.length; I++) iXt[I] = iXs[I];
                    lAnswers.add(iXt);
                }
                int iIndex = 0;
                boolean blOverflow = true;
                while (blOverflow && iIndex < iXs.length) {
                    int iT = iXs[iIndex] + 1;
                    if (iT > iXUpper) {
                        iXs[iIndex] = iXLower;
                        iIndex++;
                    } else {
                        iXs[iIndex] = iT;
                        blOverflow = false;
                    }
                }
                blNotEnd = iIndex < iXs.length;
            }
        }
        return lAnswers;
    }


    /// <summary>
    /// 算下是不是解
    /// </summary>
    /// <param name="iRatios">系数表</param>
    /// <param name="iXs">当前解</param>
    /// <param name="iM">和</param>
    /// <returns>计算结果</returns>
    public boolean GetCacuState(int[] iRatios, int[] iXs, int iM) {
        int iSum = 0;
        for (int I = 0; I < iRatios.length; I++)
            iSum += iRatios[I] * iXs[I];

        //if (iSum == iM)
        //{
        //    for (int I = 0; I < iXs.length; I++)
        //        Console.Write(string.Format("{0}\t", iXs[I]));
        //    Console.WriteLine();
        //}

        return iSum == iM;
    }
}
