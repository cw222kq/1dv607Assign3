package model.rules;

import model.Player;

public interface IHitStrategy { //samlar det som kan variera mellan klasserna i ett interface
    boolean DoHit(Player a_dealer);
}