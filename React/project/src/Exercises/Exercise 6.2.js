import React, { useEffect, useState } from 'react';

import './App.css';

import CurrencyRow from './CurrencyRow'



const BASE_URL = 'https://api.exchangeratesapi.io/latest'
const fullcurrentDate = new Date();//.toISOString();


function App() {
	const [currencyOptions, setCurrencyOptions] = React.useState([])
	const [fromCurrency, setFromCurrency] = React.useState()
	const [toCurrency, setToCurrency] = React.useState()
	const [exchangeRate, setExchangeRate] = React.useState()
	const [amount, setAmount] = React.useState(1)
	const [amountInFromCurrency, setAmountInFromCurrency] = React.useState(true)
	const [dateformat, setdateformat] = React.useState("fi-FI")
	const [correcttimezone, setcorrecttimezone] = React.useState("Europe/Helsinki")
	
	const updateDateformat = (event) => {
		switch (fromCurrency) {
			case "CAD":
				setdateformat("en-GB");
				break;
			case "HKD":
				setdateformat("zh-Hans");
				break;
			case "ISK":
				setdateformat("is-IS");
				break;
			case "USD":
				setdateformat("en-US");
				break;
			case "EUR":
				setdateformat("fi-FI");
				break;
			case "GBP":
				setdateformat("en-GB");
				break;
			case "PHP":
				setdateformat("ph-PH");
				break;
			default:
				setdateformat("en-GB");
			}
	}
	const updateCorrecttimezone = (event) => {
		switch (fromCurrency) {
			case "CAD":
				setcorrecttimezone("America/Toronto");
				break;
			case "HKD":
				setcorrecttimezone("Asia/Hong_Kong");
				break;
			case "ISK":
				setcorrecttimezone("Atlantic/Reykjavik");
				break;
			case "USD":
				setcorrecttimezone("America/New_York");
				break;
			case "EUR":
				setcorrecttimezone("Europe/Helsinki");
				break;
			case "GBP":
				setcorrecttimezone("Europe/London");
				break;
			case "PHP":
				setcorrecttimezone("Asia/Manila");
				break;
			default:
				setcorrecttimezone("Europe/London");
			}
	}
	
let toAmount, fromAmount
	if (amountInFromCurrency) {
		fromAmount = amount
		toAmount = amount * exchangeRate
	} else {
		toAmount = amount
		fromAmount = amount / exchangeRate
	}

useEffect(() => {
	fetch(BASE_URL)
		.then(res => res.json())
		.then(data => {
			const firstCurrency = Object.keys(data.rates)[0]
			setCurrencyOptions([data.base, ...Object.keys(data.rates)])
			setFromCurrency(data.base)
			setToCurrency(firstCurrency)
			setExchangeRate(data.rates[firstCurrency])
			updateCorrecttimezone(fromCurrency);
      })

  }, [])



useEffect(() => {
	if (fromCurrency != null && toCurrency != null) {
		updateDateformat(fromCurrency);
		updateCorrecttimezone(fromCurrency);
		fetch(`${BASE_URL}?base=${fromCurrency}&symbols=${toCurrency}`)
		.then(res => res.json())
		.then(data => setExchangeRate(data.rates[toCurrency]))
    }

  }, [fromCurrency, toCurrency])


	function handleFromAmountChange(e) {
		setAmount(e.target.value)
		setAmountInFromCurrency(true)
	}


	function handleToAmountChange(e) {
		setAmount(e.target.value)
		setAmountInFromCurrency(false)
	}
console.log({correcttimezone});
console.log(correcttimezone);
	return (
		<>
		<h1>Convert</h1>
		<h3>only few countries have formatting, includes USD, GBP and EUR and BST is default for missing timezones </h3>
		<div className="date" >Exhange rate at</div>
		<td>
		  {new Intl.DateTimeFormat(dateformat, {
			year: "numeric",
			month: "long",
			day: "2-digit",
			hour: 'numeric',
			minute: 'numeric',
			second: 'numeric',
		  timeZone: correcttimezone,
			timeZoneName: 'short'
		  }).format(fullcurrentDate)}
		</td>
		<CurrencyRow
		
			currencyOptions={currencyOptions}
			selectedCurrency={fromCurrency}
			onChangeCurrency={e => setFromCurrency(e.target.value)}
			onChangeAmount={handleFromAmountChange}
			amount={fromAmount}
		/>
			<div className="equals">=</div>
			<CurrencyRow
				currencyOptions={currencyOptions}
				selectedCurrency={toCurrency}
				onChangeCurrency={e => setToCurrency(e.target.value)}
				onChangeAmount={handleToAmountChange}
				amount={toAmount}
			/>
		</>
	);
}


export default App;