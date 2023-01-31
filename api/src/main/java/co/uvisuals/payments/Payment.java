package co.uvisuals.payments;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author Kacper 'DeeKaPPy' Horbacz
 * @Created 22.01.2023
 **/

@AllArgsConstructor
@Data
public class Payment {

  private final String id;
  private final String playerName;
  private final String variant;
  private final List<String> commands;

}
