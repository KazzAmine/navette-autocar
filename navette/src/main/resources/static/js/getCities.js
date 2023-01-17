//calling cities from api to display
var config = {
    method: 'get',
    url: 'https://api.countrystatecity.in/v1/countries/MA/cities',
    headers: {
      'X-CSCAPI-KEY': 'dzloa25WaExxZXZGVWNPbzd3RFJYQnVwbnUxMzVLVkE1ajV6Y1M1WQ=='
    }
  };
  
  axios(config)
  .then(function (response) {
    console.log(JSON.stringify(response.data));
  })
  .catch(function (error) {
    console.log(error);
  });