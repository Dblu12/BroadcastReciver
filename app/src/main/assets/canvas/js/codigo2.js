window.addEventListener("load", function(){
        var chart = new CanvasJS.Chart("chartContainer", {
		theme: "theme2",//theme1
		title:{
                text: "Llamadas Semanales"
              },

              data: [  //array of dataSeries
              { //dataSeries - first quarter
           /*** Change type "column" to "bar", "area", "line" or "pie"***/
               type: "column",
               name: "First Quarter",
               dataPoints: [
               { label: "Lunes",  y: InterfazAndroid.enviarDia(0)},
               				{ label: "Martes", y: InterfazAndroid.enviarDia(1)  },
               				{ label: "Miercoles", y: InterfazAndroid.enviarDia(2)  },
               				{ label: "Jueves",  y: InterfazAndroid.enviarDia(3)  },
               				{ label: "Viernes",  y: InterfazAndroid.enviarDia(4)  },
               				{ label: "Sabado",  y: InterfazAndroid.enviarDia(5)  },
               				{ label: "Domingo",  y: InterfazAndroid.enviarDia(6)  }
               ]
             },
             { //dataSeries - second quarter

              type: "column",
              name: "Second Quarter",
              dataPoints: [
              { label: "Lunes",  y: InterfazAndroid.enviarDia(7)},
                          	{ label: "Martes", y: InterfazAndroid.enviarDia(8)  },
                          	{ label: "Miercoles", y: InterfazAndroid.enviarDia(9)  },
                          	{ label: "Jueves",  y: InterfazAndroid.enviarDia(10)  },
                          	{ label: "Viernes",  y: InterfazAndroid.enviarDia(11)  },
                          	{ label: "Sabado",  y: InterfazAndroid.enviarDia(12)  },
                          	{ label: "Domingo",  y: InterfazAndroid.enviarDia(13)  }
              ]
            }
            ]
          });

	chart.render();
});

