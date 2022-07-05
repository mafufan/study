for (int i = 0; i < input; i++) {
      for (int j = 0; j < input; j++) {
        for (int h = 0; h < 3; h++) {
          if (table[i][j] <= 0) {
            histogram[0] = histogram + "*";
          } else if (
            (h * 10) + 1 <= table[i][j] &&
            table[i][j] <= (h * 10) + 10
          ) {
            histogram[h + 1] = histogram + "*";
          }
        }
      }
    }