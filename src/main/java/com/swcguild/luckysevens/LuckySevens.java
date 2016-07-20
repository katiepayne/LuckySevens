/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens;

import java.io.IOException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "LuckySevens", urlPatterns = {"/LuckySevens", "/Results"})
public class LuckySevens extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher forwarder = request.getRequestDispatcher("index.html");
        forwarder.forward(request, response); 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // store the users response in a variable.
        int startingBet = Integer.parseInt(request.getParameter("startingBetAmount") );

        // Total amount of rolls before going broke / game over.
        int rollCount = 0;

        // Highest dollar amount won.
        int maxMoney = 0;

        // Roll count when user had the most money.
        int maxCount = 0;

        // Set the current amount equal to the start amount.  We will update the current, but not the start as we play.
        int currentMoney = startingBet;

        // Two dice used in the game.
        int diceOne;
        int diceTwo;

        // Ensure you have enough money to play game.
        while (currentMoney > 0) {
            // Play game

            diceOne = rollDice();
            diceTwo = rollDice();

            int sum = diceOne + diceTwo;

            // Update Roll Count.
            rollCount++;

            // Take value of dice and determine whether to increment or decrement
            // money value.
            if (sum == 7) {
                // dice is equal to 7, add $4.
                currentMoney += 4;
            } else {
                // dice not equal to 7, subtract $1.
                currentMoney -= 1;
            }

            // Check to see if this is a new high amount of $ for this game.
            if (currentMoney > maxMoney) {
                // Update maxMoney equal to current value of the money variable.
                maxMoney = currentMoney;

                // Update when high score is updated.
                maxCount = rollCount;
            }
        }
        
        // Add data to the View's Dictionary: request.setAttribute("variableName", value);

        // Add a dictionary entry: Placeholder For = Starting Bet
        request.setAttribute("startingBet", startingBet);

        // Add a dictionary entry: Placeholder For = Total Rolls Before Going Broke
        request.setAttribute("rollCount", rollCount);
        
        // Add a dictionary entry: Placeholder For = Highest Amount Won
        request.setAttribute("maxMoney", maxMoney);

        // Add a dictionary entry: Placeholder For = Roll Count At Highest Amount Won
        request.setAttribute("maxCount", maxCount);

        // Create a request dispatcher from my populated (with game data) 
        // request.
        RequestDispatcher forwarder = request.getRequestDispatcher("response.jsp");
        forwarder.forward(request, response);    
    }
    
        
    public static int rollDice() {

      // Create an instance of the Random class.
      Random r = new Random();

      // Use the instance to get a number between 1-6... and return that number as the dice value.
      return r.nextInt((6 - 1) + 1) + 1;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
