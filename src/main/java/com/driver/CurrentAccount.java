package com.driver;

import com.driver.Exceptions.valid_license_error;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(valid(tradeLicenseId)) return;
        
        String  newTradeLicenseId = rearranged(tradeLicenseId);
        if(newTradeLicenseId.length()==0) throw new valid_license_error();
        else this.tradeLicenseId = newTradeLicenseId;
    }

    public boolean valid(String s) {
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)) return false;
        }
        return true;
    }
    
    public String rearranged(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch) > (len+1)/2) return ""; 
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(char ch : map.keySet()) pq.offer(ch);
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            char ch = pq.poll();
            if(sb.length()==0 || sb.charAt(sb.length()-1)!=ch) {
                sb.append(ch);
                int f1 = map.get(ch);
                if(--f1 > 0) {
                    map.put(ch,f1);
                    pq.offer(ch);
                }
            } else {
                char ch2 = pq.poll();
                int f2 = map.get(ch2);
                sb.append(ch2);
                if(--f2 > 0) {
                    map.put(ch2, f2);
                    pq.offer(ch2);
                }
                pq.offer(ch);
            }
        }
        return sb.toString();
    }
    
}