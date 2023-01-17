$(()=>{
    $("#searchSub").click( ()=> { 
        let villeDep=$("#villeDep");
        let villeArr=$("#villeArr");
        let selectedtime=$("#selectedTime");
        
        if(villeArr.val()==null || villeDep.val()==null){
            Toastify({
                text: "il faut selection tous les informations",
                className: "alert",
                close:true,
                style: {
                  background: "red",
                }
              }).showToast();
        }else{
            window.location.replace("/ListAbonnement/"+selectedtime.val()+"/"+villeDep.val()+"/"+villeArr.val())
        }
        
    });
});
    
