splitedURL=document.URL.split("/");
const [subID]=splitedURL.reverse();
// console.log(subID)

//calcul days between dates
const prixTotal = (date_1, date_2,prix) =>{
    let date1=new Date(date_1)
    let date2=new Date(date_2)
    let difference = date2.getTime() - date1.getTime();
    let TotalDays = Math.ceil(difference / (1000 * 3600 * 24));
    let price=TotalDays*prix
    return price;
}

//ajax method to subscribe
const subscribeEvent=(subIdd)=>{
    let moreInfo;
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/Subscription/getsubscriptionInfo/"+subIdd,
        dataType: "JSON",
        success: function (response) {
            moreInfo=response;
        },
        async:false
    });
    return moreInfo;
}
$("#btnConfirm").attr("value", subID);
let dataa=subscribeEvent(subID)
$("#product").append('<h3 class="title">'+dataa.societe["nom"]+'</h3><div class="item"><span class="price">'+dataa["prix"]+'DH/Journee</span><p class="item-name">'+dataa.villeDepart+'--->'+dataa.villeArrivee+'</p><p class="item-description">'+dataa.heureDepart+'-->'+dataa.heureArrive+'</p> </div><div class="item"><div class="mb-3"><label class="form-label" for="card_holder">Duree</label> <br><input class="form-control" type="date" id="depDate"> <div><br><input class="form-control" type="date" id="endDate"> </div></div>');

$("#profileLink").attr("href","/clientProfile/"+subID);
//click to subscribe
$("#btnConfirm").on("click",()=> {
    let totPrice=prixTotal($("#depDate").val(),$("#endDate").val(),dataa["prix"])
    let subscriptionInfos={
        "cl":{
            "cin":null
        },
        "subscription":{
            "idSubs":$("#btnConfirm").val()
        },
        "depDate":$("#depDate").val(),
        "endDate":$("#endDate").val()
        ,"active":true,
        "totalPrice":totPrice
    }
    
    
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/Abonnement/addAbonnement",
        data:JSON.stringify(subscriptionInfos),
        contentType:"application/json",
        dataType: "json",
        success: function (response) {
            Toastify({
                text: "abonnement a ete ajouter",
                className: "primary",
                close:true,
                style: {
                background: "blue",
                }
            }).showToast();


            //pdf
            var pdf = new jsPDF({
                orientation: 'p',
                unit: 'mm',
                format: 'a4',
                putOnlyUsedFonts:true
                });
            pdf.setFont("helvetica");
            pdf.setFontType("bold");
            pdf.setTextColor(0,0,255);

            pdf.text("Abonnement \n"+dataa.societe["nom"], 20, 20,{ align: 'center' });
            pdf.line("\n")
            pdf.setFont("courier");

            pdf.text(response['prenom']+" "+response['nom'], 20, 30);
            pdf.line("\n")
            
            pdf.text("CIN: "+response['cin'], 20, 30);
            pdf.line("")
            pdf.text("de: "+dataa.villeDepart+" vers : "+dataa.villeArrivee, 20, 30);
           
            pdf.line("\n")
            pdf.text("depuis :"+$("#depDate").val(), 20, 30);
            pdf.text("\n")
            pdf.text("jusqu'a :"+$("#endDate").val(), 20, 30);
            pdf.save('Sub'+subID+response["cin"]+'.pdf');
        },
        async:false
    });

});
