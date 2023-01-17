
    splitedURL=document.URL.split("/");
    const [socID]=splitedURL.reverse();
    $("#offresLink").attr("href", "/offres/"+socID);
    $("#profileLink").attr("href", "/societeProfile/"+socID);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/Subscription/getsubscriptionbysoc/"+socID,
        dataType: "json",
        success: function (response) {
            if(response.length==0){
                $("#itemContainer").append("<div>vous n'avez pas ajouter une offre</div>")
            }
            response.forEach(element => {
                $("#itemContainer").append('<div class="product"><div class="row justify-content-center align-items-center"><div class="col-md-3"><div class="product-image"><button class="btn btn-outline-danger btnDelete" value="'+element["idSubs"]+'">supprimer</button></div></div>'
                +'<div class="col-md-5 product-info"><a class="product-name" href="#">'+element["description"]+'</a>'+
               '<div class="product-specs">'+
                                               ' <div><span>de:&nbsp;</span><span class="value">'+element["villeDepart"]+'</span></div>'+
                                                '<div><span>Vers:&nbsp;</span><span class="value">'+element["villeArrivee"]+'</span></div>'+
                                                '<div><span>temps:&nbsp;</span><span class="value">DE '+element["heureDepart"]+' A '+element["villeArrivee"]+'</span></div>'+
                                           ' </div>'+
                                       ' </div>'+
                                        '<div class="col-6 col-md-2 quantity"><label class="form-label d-none d-md-block" for="quantity">Nombre d\'abonner</label><input disabled type="number" id="number" class="form-control quantity-input" value="'+element["nbrSubscribers"]+'"></div>'+
                                       ' <div class="col-6 col-md-2 price"><span>'+element["prix"]+'DH</span></div>'+
                                    '</div>'+
                               ' </div>');
            });
            // console.log(response)
        },async:false
    });
    

$(()=>{
$(".btnDelete").on("click",function() {

    // console.log($(this).val())
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/Subscription/deletesubscription/"+$(this).val(),
        dataType: "json",
        error: (response,jqXHR)=> {
            Toastify({
                text: "deleted!!",
                className: "success",
                close:true,
                style: {
                  background: "linear-gradient(to right,cyan, blue)",
                }
              }).showToast();
            
        },async:false
    });
});

    $("#btnAddSubscription").on("click",()=>{
        let description=$("#description")
        let depVille=$("#villeDep")
        let arrVille=$("#villeArr")
        let tempDep=$("#depTime")
        let tempArr=$("#arrTime")
        let mat=$("#busMat")
        let price=$("#price")
        let subid=depVille.val().slice(0,2)+arrVille.val().slice(0,3)+Math.floor(Math.random() * 500) + 1
        if(description.val()!='' && depVille.val()!='' && arrVille.val()!='' && tempDep.val()!='' && tempArr.val()!='' && mat.val()!=''){
           
            let SubscriptionData={
                "idSubs":subid,
                "description":description.val(),
                "heureDepart":tempDep.val(),
                "heureArrive":tempArr.val(),
                "villeDepart":depVille.val(),
                "villeArrivee":arrVille.val(),
                "nbrSubscribers":0,
                "prix":price.val(),
                "bus":{
                    "matricule":mat.val()
                },
                "societe":{
                    "socId":socID
                }
            }
            $.ajax({
            type: "POST",
            url: "http://localhost:8080/Subscription/addsubscription/"+socID+"/"+mat.val(),
            data: JSON.stringify(SubscriptionData),
            dataType: "json",
            contentType:"application/json",
            Error: function (response) {
                Toastify({
                    text: "Ajouter!!",
                    className: "success",
                    close:true,
                    style: {
                      background: "linear-gradient(to right,green, blue)",
                    }
                  }).showToast();
            }
        });
        }
        

        
    })
})
