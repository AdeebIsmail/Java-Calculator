import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
// Adeeb Ismail 2/20/20 700
// when  = 0  cant place number
public class myCalc extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        ArrayList<Button> buttons = new ArrayList<Button>();
        ArrayList<String> equation = new ArrayList<String>();
        Scene scene = new Scene(gridPane, 252, 450);
        Button btn_0;
        Button btn_1;
        Button btn_2;
        Button btn_3;
        Button btn_4;
        Button btn_5;
        Button btn_6;
        Button btn_7;
        Button btn_8;
        Button btn_9;
        Button btn_multi;
        Button btn_div;
        Button btn_add;
        Label numbertext = new Label();
        Label pastNum = new Label();
        Button btn_equal = new Button("=");
        Button btn_clear = new Button("C");
        Button btn_deci = new Button(".");
        Button btn_neg = new Button("+/-");
        Button btn_sub = new Button("-");
        buttons.add(btn_0 = new Button("0"));
        buttons.add(btn_1 = new Button("1"));
        buttons.add(btn_2 = new Button("2"));
        buttons.add(btn_multi = new Button("*"));
        buttons.add(btn_3 = new Button("3"));
        buttons.add(btn_4 = new Button("4"));
        buttons.add(btn_5 = new Button("5"));
        buttons.add(btn_div = new Button("/"));
        buttons.add(btn_6 = new Button("6"));
        buttons.add(btn_7 = new Button("7"));
        buttons.add(btn_8 = new Button("8"));
        buttons.add(btn_add = new Button("+"));
        buttons.add(btn_9 = new Button("9"));


        for (int i = 0; i < buttons.size(); i++) {
            Button heightAdjust = (Button) buttons.get(i);
            heightAdjust.setMinHeight(50);
            heightAdjust.setMinWidth(50);
            buttons.set(i, heightAdjust);
        }
        numbertext.setMinWidth(232);
        pastNum.setMinWidth(110);
        numbertext.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
        pastNum.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
        gridPane.add(numbertext, 1, 2, 4, 1);
        gridPane.add(pastNum, 3, 1, 4, 1);
        gridPane.add(btn_sub, 4, 8);
        btn_sub.setPrefWidth(50);
        btn_sub.setPrefHeight(50);
        gridPane.add(btn_equal, 3, 8);
        btn_equal.setMinWidth(50);
        btn_equal.setMinHeight(50);
        gridPane.add(btn_clear, 2, 8);
        btn_clear.setMinWidth(50);
        btn_clear.setMinHeight(50);
        gridPane.add(btn_deci, 1, 10, 2, 1);
        btn_deci.setMinWidth(110);
        btn_deci.setMinHeight(50);
        gridPane.add(btn_neg, 3, 10, 2, 1);
        btn_neg.setMinWidth(110);
        btn_neg.setMinHeight(50);


        int row = 1;
        int col = 5;
        for (int i = 0; i < buttons.size(); i++) {
            gridPane.add((Node) buttons.get(i), row, col);
            if (i == 3 || i == 7 || i == 11) {
                col++;
                row = 0;

            }
            row++;
        }
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER_LEFT);

        stage.setScene(scene);
        EventHandler handler = event -> {
            Button button = (Button) event.getSource();
            if (button.getText().equals(".")) {
                deci(equation, numbertext, button);
            } else if (button.getText().equals("+/-")) {
                plusminus(equation, numbertext);
            } else if (!button.getText().equals("C") && !button.getText().equals("=")) {
                if (equation.size() > 0) {
                    if (!button.getText().equals("+") && !button.getText().equals("-") && !button.getText().equals("/") && !button.getText().equals("*") && !button.getText().equals("=") && !button.getText().equals("-.") &&  !button.getText().equals(".") &&  !button.getText().equals("-")) {
                        equationstuff(equation, button, numbertext);
                    } else if (button.getText().equals("+") || button.getText().equals("-") || button.getText().equals("/") || button.getText().equals("*")) {
                        if (equation.get(equation.size() - 1).equals("+") || equation.get(equation.size() - 1).equals("-") || equation.get(equation.size() - 1).equals("/") || equation.get(equation.size() - 1).equals("*")) {
                        } else {
                            pastStuff(equation, button, numbertext, pastNum);
                        }
                    } else {
                        pastStuff(equation, button, numbertext, pastNum);
                    }
                } else {
                    numbertext.setText(button.getText());
                    equation.add(button.getText());
                }
                System.out.println(equation.toString());
            } else if (button.getText().equals("C")) {
                clear(equation, numbertext, pastNum);
            } else if ((button.getText().equals("=")) && ((!equation.get(equation.size() - 1).equals("+") && !equation.get(equation.size() - 1).equals("-") && !equation.get(equation.size() - 1).equals("/") && !equation.get(equation.size() - 1).equals("*")) && !equation.get(equation.size() - 1).equals("-.") && !equation.get(equation.size() - 1).equals(".") && !equation.get(equation.size() - 1).equals("-"))) {
                math(equation, numbertext, pastNum);

            }


        };
        btn_0.setOnAction(handler);
        btn_1.setOnAction(handler);
        btn_2.setOnAction(handler);
        btn_3.setOnAction(handler);
        btn_4.setOnAction(handler);
        btn_5.setOnAction(handler);
        btn_6.setOnAction(handler);
        btn_7.setOnAction(handler);
        btn_8.setOnAction(handler);
        btn_9.setOnAction(handler);
        btn_multi.setOnAction(handler);
        btn_div.setOnAction(handler);
        btn_add.setOnAction(handler);
        btn_sub.setOnAction(handler);
        btn_equal.setOnAction(handler);
        btn_clear.setOnAction(handler);
        btn_neg.setOnAction(handler);
        btn_deci.setOnAction(handler);

        stage.show();
        stage.setTitle("Adeeb Ismail");

    }

    public void deci(ArrayList equation, Label numbertext, Button button) {
        if (numbertext.getText().equals(".")) {

        } else if (numbertext.getText().equals("-")) {
            String s = "-";
            s += ".";
            numbertext.setText(s);
            equation.set(equation.size() - 1, s);
        } else if (equation.isEmpty()) {
            numbertext.setText(".");
            equation.add(button.getText());
        } else if (equation.size() > 0) {
            numbertext.setText(".");
            if (!button.getText().equals("+") && !button.getText().equals("-") && !button.getText().equals("/") && !button.getText().equals("*") && !button.getText().equals("=")) {
                if (!equation.get(equation.size() - 1).equals("-") && !equation.get(equation.size() - 1).equals("+") && !equation.get(equation.size() - 1).equals("/") && !equation.get(equation.size() - 1).equals("*")) {
                    String s = (String) equation.get(equation.size() - 1);
                    s += ".";
                    equation.set(equation.size() - 1, s);
                    numbertext.setText(s);
                } else {
                    equation.add(button.getText());
                }
            } else {
                equation.add(button.getText());
            }
        }
    }

    public void clear(ArrayList equation, Label numbertext, Label pastNum) {
        equation.clear();
        numbertext.setText("");
        pastNum.setText("");
    }

    public void plusminus(ArrayList equation, Label numbertext) {
        if (numbertext.getText().equals("-")) {

        } else if (equation.size() == 0) {
            numbertext.setText("-");
            equation.add("-");
        } else if (equation.get(equation.size() - 1).equals(".")) {
            String s = "-";
            s += ".";
            numbertext.setText(s);
            equation.set(equation.size() - 1, s);
        } else if (equation.get(equation.size() - 1).equals("*") || equation.get(equation.size() - 1).equals("/") || equation.get(equation.size() - 1).equals("-") || equation.get(equation.size() - 1).equals("+")) {
            numbertext.setText("-");
            equation.add("-");
        } else {
            String s = numbertext.getText();
            if (s.contains(".")) {
                Double z = Double.parseDouble(s);
                if (z > 0) {
                    z = z * -1;
                } else {
                    z = Math.abs(z);
                }
                s = Double.toString(z);
            } else {
                int z = Integer.parseInt(s);
                if (z > 0) {
                    z = z * -1;
                } else {
                    z = Math.abs(z);
                }
                s = Integer.toString(z);
            }
            equation.set(equation.size() - 1, s);
            numbertext.setText(s);
        }
    }

    public void equationstuff(ArrayList equation, Button button, Label numbertext) {
        if (numbertext.getText().equals("-")) {
            String s = "-";
            s += button.getText();
            numbertext.setText(s);
            equation.set(equation.size() - 1, s);
        } else if (button.getText().equals("0") && equation.get(equation.size() - 1).equals("/")) {

        } else if (equation.get(equation.size() - 1).equals("0")) {

            String s = (String) equation.get(equation.size() - 1);
            s += ".0";
            s += button.getText();
            equation.set(equation.size() - 1, s);
            numbertext.setText(s);

        } else if ((equation.get(equation.size() - 1).equals("-")) && (equation.get(equation.size() - 2).equals("-") || equation.get(equation.size() - 2).equals("+") || equation.get(equation.size() - 2).equals("/") || equation.get(equation.size() - 2).equals("*"))) {
            numbertext.setText(button.getText());
            String s = "-";
            s += button.getText();
            System.out.println(s);
            numbertext.setText(s);
            equation.set(equation.size() - 1, s);
        } else if (!equation.get(equation.size() - 1).equals("-") && !equation.get(equation.size() - 1).equals("+") && !equation.get(equation.size() - 1).equals("/") && !equation.get(equation.size() - 1).equals("*")) {
            numbertext.setText(button.getText());
            String s = (String) equation.get(equation.size() - 1);
            s += button.getText();
            equation.set(equation.size() - 1, s);
            numbertext.setText(s);

        } else {
            numbertext.setText(button.getText());
            equation.add(button.getText());


        }
    }

    public void math(ArrayList equation, Label numbertext, Label pastNum) {
        pastNum.setText("");
        if (equation.size() == 1) {

        } else {
            String num1 = "";
            String num2 = "";
            int fin = -1;
            double dfin = -1;
            String sign = "";
            for (int i = 0; i < equation.size(); i++) {
                if ((!equation.get(i).equals("+") || !equation.get(i).equals("-") || !equation.get(i).equals("/") || !equation.get(i).equals("*")) && num1.isEmpty()) {
                    num1 = (String) equation.get(i);
                } else if ((equation.get(i).equals("+") || equation.get(i).equals("-") || equation.get(i).equals("/") || equation.get(i).equals("*"))) {
                    sign = (String) equation.get(i);
                } else if ((!equation.get(i).equals("+") || !equation.get(i).equals("-") || !equation.get(i).equals("/") || !equation.get(i).equals("*")) && num2.isEmpty()) {
                    num2 = (String) equation.get(i);
                    double r = 0;
                    double c = 0;
                    if (num1.contains(".")) {
                        r = Double.parseDouble(num1);
                    }
                    if (num2.contains(".")) {
                        c = Double.parseDouble(num2);
                    }
                    if (!num2.contains(".")) {
                        c = Integer.parseInt(num2);
                    }
                    if (!num1.contains(".")) {
                        r = Integer.parseInt(num1);
                    }
                    if ((sign.equals("/") && (r > c || c > r))) {
                        dfin = r / c;
                        num1 = Double.toString(dfin);
                        num2 = "";
                        sign = "";
                    } else if (num1.contains(".") || num2.contains(".")) {
                        if (sign.equals("+")) {
                            dfin = (r + c);
                        } else if (sign.equals("-")) {
                            dfin = (r - c);
                        } else if (sign.equals("*")) {
                            dfin = (r * c);
                        } else if (sign.equals("/")) {
                            dfin = (r / c);
                        }
                        num1 = Double.toString(dfin);
                        num2 = "";
                        sign = "";
                    } else {
                        if (sign.equals("+")) {
                            fin = (int) (r + c);
                        } else if (sign.equals("-")) {
                            fin = (int) (r - c);
                        } else if (sign.equals("*")) {
                            fin = (int) (r * c);
                        } else if (sign.equals("/")) {
                            fin = (int) (r / c);
                        }
                        num1 = Integer.toString(fin);
                        num2 = "";
                        sign = "";

                    }

                }
            }
            if (num1.contains(".") || num2.contains(".")) {
                if (fin == 0 || dfin == 0.0) {
                    numbertext.setText("0.0");
                    equation.clear();
                    equation.add(Double.toString(dfin));
                } else {
                    numbertext.setText(Double.toString(dfin));
                    equation.clear();
                    equation.add(Double.toString(dfin));
                }


            } else {
                if (fin == 0 || dfin == 0.0) {
                    numbertext.setText("0.0");
                    equation.clear();
                    equation.add(Integer.toString(fin));
                } else {
                    numbertext.setText(Integer.toString(fin));
                    equation.clear();
                    equation.add(Integer.toString(fin));
                }
            }

        }

    }

    public void pastStuff(ArrayList equation, Button button, Label numbertext, Label pastNum) {
        String num1 = "";
        String num2 = "";
        int fin = -1;
        double dfin = -1;
        String sign = "";
        equation.add(button.getText());
        if (equation.size() > 1) {
            pastNum.setText(equation.get(equation.size() - 2).toString() + equation.get(equation.size() - 1).toString());
            numbertext.setText("");
            if (equation.size() > 2) {
                for (int i = 0; i < equation.size(); i++) {
                    if ((!equation.get(i).equals("+") || !equation.get(i).equals("-") || !equation.get(i).equals("/") || !equation.get(i).equals("*")) && num1.isEmpty()) {
                        num1 = (String) equation.get(i);
                    } else if ((equation.get(i).equals("+") || equation.get(i).equals("-") || equation.get(i).equals("/") || equation.get(i).equals("*"))) {
                        sign = (String) equation.get(i);
                    } else if ((!equation.get(i).equals("+") || !equation.get(i).equals("-") || !equation.get(i).equals("/") || !equation.get(i).equals("*")) && num2.isEmpty()) {
                        num2 = (String) equation.get(i);
                        double r = 0;
                        double c = 0;
                        if (num1.contains(".")) {
                            r = Double.parseDouble(num1);
                        }
                        if (num2.contains(".")) {
                            c = Double.parseDouble(num2);
                        }
                        if (!num2.contains(".")) {
                            c = Integer.parseInt(num2);
                        }
                        if (!num1.contains(".")) {
                            r = Integer.parseInt(num1);
                        }
                        if ((sign.equals("/") && (r > c || c > r))) {
                            dfin = r / c;
                            num1 = Double.toString(dfin);
                            num2 = "";
                            sign = "";
                        } else if (num1.contains(".") || num2.contains(".")) {
                            if (sign.equals("+")) {
                                dfin = (r + c);
                            } else if (sign.equals("-")) {
                                dfin = (r - c);
                            } else if (sign.equals("*")) {
                                dfin = (r * c);
                            } else if (sign.equals("/")) {
                                dfin = (r / c);
                            }
                            num1 = Double.toString(dfin);
                            num2 = "";
                            sign = "";
                        } else {
                            if (sign.equals("+")) {
                                fin = (int) (r + c);
                            } else if (sign.equals("-")) {
                                fin = (int) (r - c);
                            } else if (sign.equals("*")) {
                                fin = (int) (r * c);
                            } else if (sign.equals("/")) {
                                fin = (int) (r / c);
                            }
                            num1 = Integer.toString(fin);
                            num2 = "";
                            sign = "";

                        }

                    }
                }
                if (num1.contains(".") || num2.contains(".")) {
                    if (fin == 0 || dfin == 0.0) {
                        pastNum.setText("0.0");
                    } else {
                        pastNum.setText(Double.toString(dfin));
                    }
                } else {
                    if (fin == 0 || dfin == 0.0) {
                        pastNum.setText("0.0");
                    } else {
                        pastNum.setText(Integer.toString(fin));
                    }
                }
            }
        }
    }


}

