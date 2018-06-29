package com.clearlydecoded.commander.demo.command;

import com.clearlydecoded.commander.CommandResponse;
import com.clearlydecoded.commander.demo.model.Cookie;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaxSugarOrderResponse implements CommandResponse {

  private List<Cookie> cookies;

  private int sugarTotal;

}
