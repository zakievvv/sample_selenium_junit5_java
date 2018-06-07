#!/usr/bin/env bash
set -ev

## Install FirefoxTest and Driver
brew install geckodriver
brew tap homebrew/cask
brew cask install firefox

## Install ChromeTest and Driver
brew cask install chromedriver
brew cask install google-chrome

## Install PhantomJS
brew install phantomjs

## Install OperaTest and Driver
brew install homebrew/cask/operadriver
brew install homebrew/cask/opera






