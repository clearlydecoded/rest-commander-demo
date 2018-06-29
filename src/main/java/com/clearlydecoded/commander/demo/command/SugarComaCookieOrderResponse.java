package com.clearlydecoded.commander.demo.command;

import com.clearlydecoded.commander.CommandResponse;
import com.clearlydecoded.commander.demo.model.Cookie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SugarComaCookieOrderResponse implements CommandResponse {

  private Cookie sugarComaCookie;
}
