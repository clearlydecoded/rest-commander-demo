/*
 * Copyright 2018 Yaakov Chaikin (yaakov@ClearlyDecoded.com). Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 * by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See
 * the License for the specific language governing permissions and limitations under the License.
 */
package com.clearlydecoded.messenger.demo.service;

import com.clearlydecoded.messenger.demo.model.Cookie;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Demo class that serves as a fake store of different type of cookies.
 *
 * @author Yaakov Chaikin (yaakov@ClearlyDecoded.com)
 */
@Service
public class CookieStoreService {

  private static Cookie[] cookieStore = {
      new Cookie("Plain", 15, new String[]{}),
      new Cookie("Chocolate Chip", 30, new String[]{"chocolate chip"}),
      new Cookie("Peanut Butter", 20, new String[]{"peanut butter"}),
      new Cookie("Peanut Butter Chocolate Chip", 50,
          new String[]{"peanut butter", "chocolate chip"}),
      new Cookie("Snicker-doodles", 60, new String[]{"cinnamon", "sugar"}),
      new Cookie("Sugar", 90, new String[]{"sugar", "more sugar"}),
      new Cookie("Ginger", 60, new String[]{"ginger", "sugar"}),
      new Cookie("Ginger Sugar peanut butter", 150,
          new String[]{"ginger", "sugar", "peanut butter", "more sugar"}),
      new Cookie("Sugar Sugar", 300,
          new String[]{"sugar", "more sugar", "even more sugar", "diabetes"})
  };

  public Cookie giveMeSugarComaCookie() {

    // Loop over cookieStore and choose the one with the most sugar in it
    Cookie theCookie = cookieStore[0];
    for (Cookie cookie : cookieStore) {
      if (cookie.getSugarInGrams() > theCookie.getSugarInGrams()) {
        theCookie = cookie;
      }
    }

    return theCookie;
  }

  public Cookie giveMeFirstOneWithAdditionOf(String addition) {

    // Lowercase it to make comparison easier
    addition = addition.toLowerCase();

    // Loop over cookies in store
    for (Cookie cookie : cookieStore) {

      // Loop over this cookie additions
      for (String cookieAddition : cookie.getAdditions()) {
        if (cookieAddition.contains(addition)) {
          return cookie;
        }
      }
    }

    // No cookie with addition is found
    return null;
  }

  public List<Cookie> giveMeCookiesUpToMaxSugar(int maxSugarInGrams) {

    List<Cookie> cookies = new ArrayList<>();

    int currentSugarLevel = 0;
    int cookieIndex = 0;
    while (true) {
      Cookie currentCookie = cookieStore[cookieIndex];

      // Check if adding this cookie would exceed maxSugarInGrams; return if yes
      if (currentSugarLevel + currentCookie.getSugarInGrams() > maxSugarInGrams) {
        return cookies;
      }

      cookies.add(currentCookie);
      currentSugarLevel += currentCookie.getSugarInGrams();
      cookieIndex++;

      // Check that cookieIndex doesn't exceed last index in the store; if yes, reset to 0
      if (cookieIndex == cookieStore.length) {
        cookieIndex = 0;
      }
    }
  }

}
