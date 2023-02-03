export const availableLanguages = [
  { shortCode: "EN", label: "English" },
  { shortCode: "FR", label: "Français" },
  { shortCode: "IT", label: "Italiano" },
  { shortCode: "FI", label: "Suomi" },
];

export const initialState = {
  selectedLanguage: "EN"
};

export function reducer(state, action) {
  const { type, payload } = action;
  switch (type) {
    case "LANGUAGE_UPDATE": {
      return { ...state, selectedLanguage: payload };
    }
    default:
      return state;
  }
}
