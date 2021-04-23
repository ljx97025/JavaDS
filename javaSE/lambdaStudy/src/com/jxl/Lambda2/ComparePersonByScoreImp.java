package com.jxl.Lambda2;

/**
 * @ClassName : ComparePersonByScoreImp
 * @Author : ljx
 * @Date: 2021/4/23 14:52
 * @Description : 比较分数
 */
public class ComparePersonByScoreImp implements PersonDao {

    private int score;

    public ComparePersonByScoreImp(int score) {
        this.score = score;
    }

    @Override
    public boolean compare(Person p) {
        return p.getScore()>this.score;
    }
}
