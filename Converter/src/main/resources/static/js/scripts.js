// Custom Scripts
// Custom scripts
const btnSubmit = document.querySelector('#submit')
const btnChoiseCurrency = document.querySelectorAll('.choise-currency');
const btnCurrentCurrency = document.querySelectorAll('.item-currency');
const selectNow = document.querySelector('#currency');
const selectSale = document.querySelector('#sale-currency');
const input = document.querySelector('#available-currency');
const result = document.querySelector('#purchased-currency');
const btnUpdateBase = document.querySelector('#update');
const lastUpdateText = document.querySelector('.lastupdate-date');
const statsDayText = document.querySelector('.day-stats')
const statsAllDayText = document.querySelector('.allday-stats')

//host
const hostCurrency = 'http://localhost/base_json.json'
const hostStats = 'http://localhost/stats.json'
const hostInfo = 'http://localhost/transactionInfo.json'


// Получения валюты и отрисовка в select 
async function getDataCurul2() {
  //const responsive = await fetch('http://data.fixer.io/api/latest?access_key=2adea4d5f675b20c882ca0c215cf7ba3&format=1');
  
  const responsive = await fetch(hostCurrency);
  const data = await responsive.json();
  const resultData = await data;
  const valutes = resultData.rates
  console.log(valutes);
  const dataUpdate = resultData.date
  let dateg = new Date(dataUpdate)
  const arr = Object.entries(valutes)
  for (let i = 0; i < arr.length; i++) {
    selectNow.innerHTML += `<option value="${arr[i][0]}">${arr[i][0]}</option>`;
    selectSale.innerHTML += `<option value="${arr[i][0]}">${arr[i][0]}</option>`;
  };
  lastUpdateText.textContent += (' ' + dateg);
}
getDataCurul2();
//// Получения статистики и отрисовка
async function getStatsData() {

  const responsive = await fetch(hostStats);
  const data = await responsive.json();
  const resultStats = await data;
  const arr = Object.entries(resultStats)
 
  for (let i = 0; i < arr.length; i++) {
    statsDayText.innerHTML = `${arr[0][1]}`;
    statsAllDayText.innerHTML = `${arr[1][1]}`;
  };
}
getStatsData();

//Событие покупки валюты(получаем объект с информацией о покупке)
btnSubmit.addEventListener('click',async function () {
  const input1 = document.querySelector('#available-currency').value
  const input2 = document.querySelector('#purchased-currency').value

  let transactionInfo = {}

  const today = new Date()
 
  transactionInfo.idUser = Math.floor(Math.random());
  transactionInfo.fromCurrency = parseFloat(input1);
  transactionInfo.fromCurrencyAmount = selectNow.value;
  transactionInfo.toCurrency = parseFloat(input2);
  transactionInfo.toCurrencyAmount = selectSale.value;
  transactionInfo.transactionDate = today.getTime();

  const response = await fetch(hostInfo, {
    method: 'POST',
    body: JSON.stringify({
      transactionInfo
    }),
    headers: {
      'Content-Type': 'application/json',
    }
  });

  const CurrencyItem = await response.json();
  console.log(CurrencyItem);
})
//Событие обновления базы данных
 btnUpdateBase.addEventListener('click', async function () {
  const responsive = await fetch('http://localhost/base_json.json');
  const data = await responsive.json();
  const resultData = await data;
  console.log(resultData);
})
//Ввод валюты в первый инпут и конвертация(результат во второй инпут)
input.oninput = function () {
  let currency1 = selectNow.value
  let currency2 = selectSale.value
  let nowInptut = input.value
  

  if (currency1 != currency2) {
    convert(currency1, currency2, nowInptut)
  } else { 
    console.log(Error);
  }
};

result.oninput = function () {
  let currency1 = selectNow.value
  let currency2 = selectSale.value
  let nowInptut = result.value
  

  if (currency1 != currency2) {
    convertRev(currency1, currency2, nowInptut)
  } else { 
    console.log(Error);
  }
};

//Функция конвертации
 function convert(currency1, currency2, inputs) {
    let nowInptuts = input.value
    let nowInptut = result.value
   
    fetch(hostCurrency)
      .then(resp => resp.json())
      .then((data) => {
        let fixVal1 = (data.rates[currency1]).toFixed(2);
        let fixVal2 = (data.rates[currency2]).toFixed(2);
        let resultConvent = ((fixVal2 / fixVal1) * inputs).toFixed(3);
        result.value = resultConvent;
      });

}

function convertRev(currency1, currency2, inputs) {
  let nowInptuts = input.value
  let nowInptut = result.value
 
  fetch(hostCurrency)
    .then(resp => resp.json())
    .then((data) => {
      let fixVal1 = (data.rates[currency1]).toFixed(2);
      let fixVal2 = (data.rates[currency2]).toFixed(2);
      let resultConvent = ((fixVal1 / fixVal2) * inputs).toFixed(3);
      input.value = resultConvent;
    });

}


//Вход и получение объекта о пользователе
const btnSingIn = document.querySelector('#btn-sign-in');
const btnSingUp = document.querySelector('#btn-sign-up');
const inputEmail= document.querySelector('#email-address');
const inputPassword = document.querySelector('#password');
const form = document.querySelector('#form-sign')

form.addEventListener('submit', function (e) {
  e.preventDefault();
})

btnSingUp.addEventListener('click', function () {
    
  const userRegInfo = {};
  
  userRegInfo.email = inputEmail.value;
  userRegInfo.passwrod = inputPassword.value;
  console.log(userRegInfo);
  
})

btnSingIn.addEventListener('click', function() {

  const userInfo = {};

  userInfo.email = inputEmail.value;
  userInfo.passwrod = inputPassword.value;
  console.log(userInfo);
})



// Модальное окно
function bindModal(trigger, modal, close) {
    trigger = document.querySelector(trigger),
    modal = document.querySelector(modal),
    close = document.querySelector(close)

  const body = document.body

  trigger.addEventListener('click', e => {
    e.preventDefault()
    modal.style.display = 'flex'
    body.classList.add('locked')
  });
  close.addEventListener('click', () => {
    modal.style.display = 'none'
     body.classList.remove('locked')
  });
  modal.addEventListener('click', e => {
    if (e.target === modal) {
      modal.style.display = 'none'
       body.classList.remove('locked')
    }
  })
}

// ПЕРВЫЙ аргумент - класс кнопки, при клике на которую будет открываться модальное окно.
// ВТОРОЙ аргумент - класс самого модального окна.
// ТРЕТИЙ аргумент - класс кнопки, при клике на которую будет закрываться модальное окно.
bindModal('.btn-sign', '.modal__wrapper', '.modal__close')


