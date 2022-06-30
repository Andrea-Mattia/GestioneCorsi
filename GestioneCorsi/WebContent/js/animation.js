const speed = 100;
let actualSpeed = 0;

function incEltNbr(id) {
  elt = document.getElementById(id);
  endNbr = Number(document.getElementById(id).innerHTML);
  incNbrRec(0, endNbr, elt);
}


function incNbrRec(i, endNbr, elt) {
	if(endNbr > speed)
		actualSpeed = speed/15;
	else
		actualSpeed = speed;
  if (i <= endNbr) {
    elt.innerHTML = i;
    setTimeout(function() {
      incNbrRec(i + 1, endNbr, elt);
    }, actualSpeed);
  }
}


function incNbr(){
  incEltNbr("nbr");
}

incEltNbr("nbr1");
incEltNbr("nbr2");
incEltNbr("nbr3");