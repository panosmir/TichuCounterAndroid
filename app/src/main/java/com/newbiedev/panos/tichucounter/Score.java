package com.newbiedev.panos.tichucounter;

/**
 * Created by Panos on 1/2/2017.
 */

public class Score {

    private int _scoreA, _scoreB;

    public Score(int _scoreA, int _scoreB) {
        this._scoreA = _scoreA;
        this._scoreB = _scoreB;
    }

    public Score() {
    }

    public int get_scoreA() {
        return _scoreA;
    }

    public void set_scoreA(int _scoreA) {
        this._scoreA = _scoreA;
    }

    public int get_scoreB() {
        return _scoreB;
    }

    public void set_scoreB(int _scoreB) {
        this._scoreB = _scoreB;
    }
}
