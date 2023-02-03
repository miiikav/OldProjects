import React from 'react';
import './App.css';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import MenuItem from '@material-ui/core/MenuItem';
import Menu from '@material-ui/core/Menu';
import Button from '@material-ui/core/Button';
import Box from '@material-ui/core/Box';
import texts from './texts.json';

const useStyles = makeStyles(theme => ({
	menuButton: {
		marginRight: theme.spacing(2),
	},
}));

function App() {
	const [anchorEl, setAnchorEl] = React.useState(null);
	const [locale, setLocale] = React.useState("en");
	const [supportedLocales, setSupportedLocales] = React.useState([]);
	
	const menuOpen = Boolean(anchorEl);
	
	const handleMenu = event => {
		setAnchorEl(event.currentTarget);
	};
	const handleMenuClose = () => {
		setAnchorEl(null);
	};
	
	const df = new Intl.DateTimeFormat(locale, {weekday: 'short', day: 'numeric', month: 'long'});
	const nf = new Intl.NumberFormat(locale);
	const pf = new Intl.NumberFormat(locale, { style: 'percent', maximumFractionDigits: 0 });
	const cf = new Intl.NumberFormat(locale, { style: 'currency', currency: 'INR' });
	
	const bundle = texts.hasOwnProperty(locale)?texts[locale]:texts["en"];
	
	// using use effect with an empty arrays as the second parameter
	// this makes this code run once after the page has first been displayed
	React.useEffect(() => {
		const allLocales = [];
		for (let i = 0; i < "abcdefghijklmnopqrstuvwxyz".length; i++) {
			for (let j = 0; j < "abcdefghijklmnopqrstuvwxyz".length; j++) {
				let languageString = "abcdefghijklmnopqrstuvwxyz"[i] + "abcdefghijklmnopqrstuvwxyz"[j];
				let supported = Intl.NumberFormat.supportedLocalesOf(languageString);
				if (supported.length > 0)
					allLocales.push(supported[0]);
			}
		}
		setSupportedLocales(allLocales);
	}, []);
	
	const styledClasses = useStyles();
	
	const number = 1.32576;
	
	return (
		<div className="App">
			<Button
				variant="contained" 
				edge="start" 
				className={styledClasses.menuButton} 
				color="inherit" 
				onClick={handleMenu}
			>
				{locale}
			</Button>
			<Menu
				id="locale-menu"
				anchorEl={anchorEl}
				anchorOrigin={{
					vertical: 'top',
					horizontal: 'right',
				}}
				keepMounted
				transformOrigin={{
					vertical: 'top',
					horizontal: 'right',
				}}
				open={menuOpen}
				onClose={handleMenuClose}
			>
				{
					supportedLocales.map((item, index) =>  {
						let l = new Intl.Locale(item);
						return (
							<MenuItem 
								key={"localeItem_" + index + "_" + item} 
								onClick={(event) => {setLocale(item); setAnchorEl(null);}}
							>
								{l.language}
							</MenuItem>
						)
					})
				}
			</Menu>
			
			<Box>
				<Box><Typography variant="h6" className={styledClasses.title}>{bundle.DATE_IS}:  {df.format(new Date())}</Typography></Box>
				<Box><Typography variant="h6" className={styledClasses.title}>{bundle.NUMBER_IS}: {nf.format(number)}</Typography></Box>
				<Box><Typography variant="h6" className={styledClasses.title}>{bundle.BALANCE_IS}: {cf.format(number)}</Typography></Box>
				<Box><Typography variant="h6" className={styledClasses.title}>{bundle.PERCENTAGE_IS}: {pf.format(number)}</Typography></Box>
			</Box>
		</div>
	);
}

export default App;
