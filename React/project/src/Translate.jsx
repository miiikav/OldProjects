import React, { Fragment, useContext } from "react";

import { LocalisationContext } from "./localisation";

export default function Translator({ token }) {
  const {
    localisationStore: [state],
    dictionary
  } = useContext(LocalisationContext);

  const { selectedLanguage } = state;

  const translatedToken = dictionary[selectedLanguage][token];

  return <Fragment>{translatedToken}</Fragment>;
}
