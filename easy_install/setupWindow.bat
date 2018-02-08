SET runDir=%~dp0
echo %runDir:~0,-1%
xcopy /s %runDir%\libs %UserProfile%\wpilib\user\java\lib\
echo "Installation complete"
pause
