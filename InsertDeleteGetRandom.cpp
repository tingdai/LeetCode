#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>

using namespace std;

class RandomizedSet {
public:
    vector<int> vecs;
    int seed;
    /** Initialize your data structure here. */
    RandomizedSet() {
    	seed = time(NULL);
    	srand(seed);
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val) {
    	vector<int>::iterator it = vecs.begin();
        for(it = vecs.begin(); it != vecs.end(); it++){
            if(val == *it){
                return false;
            }
        }
        vecs.insert(it, val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val) {
        for(vector<int>::iterator it = vecs.begin(); it != vecs.end(); it++){
            if(val == *it){
                vecs.erase(it);
                return true;
            }
        }
        return false;
    }

    /** Get a random element from the set. */
    int getRandom() {
    	int random_number = rand();
    	int index = random_number % vecs.size();
    	return vecs.at(index);
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * bool param_1 = obj.insert(val);
 * bool param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
