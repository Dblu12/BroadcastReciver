window.addEventListener("load", function(){
        var chart = new CanvasJS.Chart("chartContainer", {
		theme: "theme2",//theme1
		title:{
			text: "Llamadas Semanales"
		},
		animationEnabled: false,   // change to true
		data: [              
		{
			// Change type to "bar", "area", "spline", "pie",etc.
			type: "column",
			dataPoints: [
				{ label: "Lunes",  y: InterfazAndroid.enviarDia(0)},
				{ label: "Martes", y: InterfazAndroid.enviarDia(1)  },
				{ label: "Miercoles", y: InterfazAndroid.enviarDia(2)  },
				{ label: "Jueves",  y: InterfazAndroid.enviarDia(3)  },
				{ label: "Viernes",  y: InterfazAndroid.enviarDia(4)  },
				{ label: "Sabado",  y: InterfazAndroid.enviarDia(5)  },
				{ label: "Domingo",  y: InterfazAndroid.enviarDia(6)  }
			]
		}
		]
	});
	chart.render();
});

