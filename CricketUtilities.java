		if(drawlines)  		
		{
			// Outer ring of doubles
            int outerdoublesx = (int) ((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES);
            int outerdoublesy = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES));
			
            g.drawOval((FRAME_WIDTH / 2) - outerdoublesx, (FRAME_HEIGHT / 2) - outerdoublesy, outerdoublesx * 2, outerdoublesy * 2);
			
            for (int i = 1; i <= COUNT; i++) 
            {
				// Degrees d: COUNT / (2 * PI)
                double degrees =  (Math.PI * 2 / (double) COUNT ) * i + (Math.PI * 2 / (double) COUNT ) * 0.5;
                // Position y: (FRAME_WIDTH / 2) * Math.sin (degrees)
                int y = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * Math.sin(degrees)) + (FRAME_HEIGHT / 2));
                int y1 = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * OUTER_BULL* Math.sin(degrees)) + (FRAME_HEIGHT / 2));
                // Position x: (FRAME_HEIGHT / 2) * Math.cos (degrees)
                int x = (int) (((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * Math.cos(degrees)) + (FRAME_WIDTH /2));

                int x1 = (int) ((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * OUTER_BULL * Math.cos(degrees)) + (FRAME_WIDTH /2);

                g.drawLine(x, y, x1, y1);
                g.fillOval(x - 5, y - 5, 10, 10);

			}

            int innerdoublesx = (int) ((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * INNER_DOUBLES);
            int innerrdoublesy = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * INNER_DOUBLES));
			
            g.drawOval((FRAME_WIDTH / 2) - innerdoublesx, (FRAME_HEIGHT / 2) - innerrdoublesy, innerdoublesx * 2, innerrdoublesy * 2);

            for (int i = 1; i <= COUNT; i++)
			{
                // Degrees d: COUNT / (2 * PI)
                double degrees =  (Math.PI * 2 / (double) COUNT ) * i + (Math.PI * 2 / (double) COUNT ) * 0.5;
                // Position y: (FRAME_WIDTH / 2) * Math.sin (degrees)
                int y = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * INNER_DOUBLES * Math.sin(degrees)) + (FRAME_HEIGHT / 2));
                // Position x: (FRAME_HEIGHT / 2) * Math.cos (degrees)
                int x = (int) (((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * INNER_DOUBLES* Math.cos(degrees)) + (FRAME_WIDTH /2));
                g.fillOval(x - 5, y - 5, 10, 10);
            }

            // Outer Triples
            int outertriplesx = (int) ((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * OUTER_TRIPLES);
            int outertriplesy = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * OUTER_TRIPLES));
			
            g.drawOval((FRAME_WIDTH / 2) - outertriplesx, (FRAME_HEIGHT / 2) - outertriplesy, outertriplesx * 2, outertriplesy * 2);

            for (int i = 1; i <= COUNT; i++) {
                // Degrees d: COUNT / (2 * PI)
                double degrees =  (Math.PI * 2 / (double) COUNT ) * i + (Math.PI * 2 / (double) COUNT ) * 0.5;
                // Position y: (FRAME_WIDTH / 2) * Math.sin (degrees)
                int y = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * OUTER_TRIPLES * Math.sin(degrees)) + (FRAME_HEIGHT / 2));
                // Position x: (FRAME_HEIGHT / 2) * Math.cos (degrees)
                int x = (int) (((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * OUTER_TRIPLES * Math.cos(degrees)) + (FRAME_WIDTH /2));
                g.fillOval(x - 5, y - 5, 10, 10);
            }

            // Inner Triples
            int innertriplesx = (int) ((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * INNER_TRIPLES);
            int innertriplesy = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * INNER_TRIPLES));
			
            g.drawOval((FRAME_WIDTH / 2) - innertriplesx, (FRAME_HEIGHT / 2) - innertriplesy, innertriplesx * 2, innertriplesy * 2);

            for (int i = 1; i <= COUNT; i++) 
            {   // Degrees d: COUNT / (2 * PI)
                double degrees =  (Math.PI * 2 / (double) COUNT ) * i + (Math.PI * 2 / (double) COUNT ) * 0.5;
                // Position y: (FRAME_WIDTH / 2) * Math.sin (degrees)
                int y = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * INNER_TRIPLES * Math.sin(degrees)) + (FRAME_HEIGHT / 2));
                // Position x: (FRAME_HEIGHT / 2) * Math.cos (degrees)
                int x = (int) (((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * INNER_TRIPLES * Math.cos(degrees)) + (FRAME_WIDTH /2));
                g.fillOval(x - 5, y - 5, 10, 10);
            }

            int bullx = (int) ((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * OUTER_BULL);
            int bully = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * OUTER_BULL));
            g.fillOval((FRAME_WIDTH /2) - bullx, (FRAME_HEIGHT / 2) - bully, bullx * 2, bully * 2);

            g.setColor(new Color(128, 0, 15));
			
            int bullseyex = (int) ((FRAME_WIDTH/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * OUTER_BULLSEYE);
            int bullseyey = (int) (((FRAME_HEIGHT/2) * OUTER_TEXT_MARGIN * OUTER_DOUBLES * OUTER_BULLSEYE));
            g.fillOval((FRAME_WIDTH /2) - bullseyex, (FRAME_HEIGHT / 2) - bullseyey, bullseyex * 2, bullseyey * 2);
        } /***************************/
