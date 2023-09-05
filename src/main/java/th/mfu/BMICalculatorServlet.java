package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns="/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weight=request.getParameter("weight");
        String height=request.getParameter("height");
        double bmiWeight=Double.parseDouble(weight);
        double bmiHeight=Double.parseDouble(height);
        //TODO: calculate bmi
        double BMI=Math.round(bmiWeight/(bmiHeight*bmiHeight));
        
        //TODO: determine the built from BMI
        String answer;
        if(BMI<18.5)
        {
            answer="underweight";
        }
        else if (BMI>=18.5&& BMI<25)
        {
            answer="normal";
        }
        else if (BMI>=25 && BMI<30)
        {
            answer="overweight";
        }
        else if(BMI>=30 && BMI<35)
        {
            answer="obese";
        }
        else
        {
            answer="extremely obese";
        }
      
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("BMI", BMI);
        request.setAttribute("answer", answer);

        //TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
           
    }
    
}
