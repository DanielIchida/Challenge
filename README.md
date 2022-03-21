<H1>Xmen MercadoLibre</H1>
<h2>Nivel 1</h2>
<p>Estrategia para el algoritmo</p>
<p>1. Convertir el Arreglo de String a una Matriz Tipo Char</p>
<p>2. Cree un pequeño arreglo con las letras del cadena ADN</p>
<p>3. Compare las letras de la cadena con la matriz tipo char</p>
<p>4. Si encontraba una palabra igual en la matriz comenzaba a validarme los patrones</p>
<p>5. los patrones que hice fue busqueda horizontal,vertical,Oblicua</p>
<p>6. Cada patron iba guardando 1 si encontraba 4 letras consecutivas</p>
<p>7. Cuando el patron fuera mayor a 1 entonces es muntante si no es humano</p>
<h2>Nivel 2</h2>
<p>(POST )https://xmen-mutant.herokuapp.com/mutant</p>
<P>(Request) {"dna" : ["ATGCAA","CAGTGC","TCATCT","AGACTG","TCGTCA","TCACTG"]}</P>
<p>(Response) { "mutant": true }</p>
<h2>Nivel 3</h2>
<p>(GET) https://xmen-mutant.herokuapp.com/stats</p>
<p>(Response) {"countMutantDna": 1,"countHumanDna": 2,"ratio": 0.5}</p>
<p>Servicio publicado en Heroku (https://dashboard.heroku.com/)</p>
<p>Se utiliza base de datos Postgress</p>
<p>Test coverage informe en la carpeta jacocoHtml</p>
<p>Se alcanzo un coverage del (84%)</p>
<p><b>Notas</b></p>
<p>En heroku se uso una version free para publicar el proyecto el nivel de procesamiento y plmacenamiento es limitado</p>
<p>https://www.heroku.com/pricing</p>
<p>Se pueden realizar test del servicio en Postman</p>
<p>Se implemento Arquitectura Hexagonal (SpringBoot)</p>
<p>Esta arquitectura se centra en el dominio(reglas de negocio) separando las capas externas</p>
<p>Esto trae una mejor mantenibilidad y escabilidad en las aplicaciones</p>
