/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import data.Vote;

/**
* Local service that registers votes.
*/
public interface VotesDB {
    void registerVote(Vote vote);
    List<Vote> getVotes();
}
