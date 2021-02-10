# dot source variables
. .\variables.ps1

$gen2 = Get-VMFirmware $VMName
gen2.BootOrder
$gen2File = $gen2.BootOrder[0]
echo $gen2File
Set-VMFirmware -VMName $VMName -FirstBootDevice $gen2File
Get-VMFirmware $VMName

Get-VMDvdDrive -VMName $VMName -ControllerNumber 0 | Remove-VMDvdDrive
Get-VMScsiController -VMName $VMName -ControllerNumber 1 | Remove-VMScsiController

Start-VM -Name $VMName
VMConnect $HOSTNAMEVM $VMName